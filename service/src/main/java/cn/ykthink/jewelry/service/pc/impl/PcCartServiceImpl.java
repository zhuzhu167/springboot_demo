package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.exception.cmsException.storeException;
import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.model.common.po.OrderCommodityPO;
import cn.ykthink.jewelry.model.common.po.OrderJewelryPO;
import cn.ykthink.jewelry.model.common.po.OrderPO;
import cn.ykthink.jewelry.model.pc.cart.bo.PcUserPayCartBO;
import cn.ykthink.jewelry.model.pc.cart.to.PcCartReceiverInfoTO;
import cn.ykthink.jewelry.model.pc.cart.vo.PcUserCartVO;
import cn.ykthink.jewelry.orm.pc.PcCartMapper;
import cn.ykthink.jewelry.service.pc.PcCartService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * program: jewelry
 * description:PC购物车Service实现类
 * author: mi
 * create: 2019-05-09 17:00
 **/
@Service
public class PcCartServiceImpl implements PcCartService {
    @Resource
    PcCartMapper pcCartMapper;

    @Override
    public ResponseEntity<Object> cart(Integer pageNum, Integer pageSize) {
        String userUuid = JWTokenUtil.getJWTokenUuid();
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        JSONObject response = new JSONObject();
        List<PcUserCartVO> pcUserCartVOList = pcCartMapper.selectCart(userUuid);
        BigDecimal sumPrice = new BigDecimal("0");
        for (PcUserCartVO p : pcUserCartVOList) {
            //获取购物车总价
            sumPrice = sumPrice.add(p.getPrice());
        }
        response.put("sumPrice", sumPrice);
        response.put("total", page.getTotal());
        response.put("response", page.getResult());
        return ResponseEntitySupport.success(response);
    }

    @Override
    public ResponseEntity<Object> removeCart(String cartCommodityUuid) {
        if (pcCartMapper.removeIsDeleted(cartCommodityUuid) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
        }
    }

    @Override
    @Transactional
    public ResponseEntity<Object> orderCart(PcUserPayCartBO body) {
        if (body.getCartCommodityUuidList().size() == 0) {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "购物车不能为空", "Shopping cart cannot be empty");
        }
        String userUuid = JWTokenUtil.getJWTokenUuid();
        //检测购物车中商品是否生成过订单
        if (pcCartMapper.checkCart(body.getCartCommodityUuidList()) > 0) {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "存在已结单购物车信息", "Existing order shopping cart information");
        }
        OrderPO orderPO = new OrderPO();
        /**
         * 生成订单
         * 1.生成订单号
         * 2.设置收货人信息
         * 3.设置订单总额
         * 4.生成订单
         * 5.设置订单珠宝信息->生成订单珠宝->改变购物车珠宝order状态->设置订单商品信息->生成订单商品->改变购物车订单商品order状态
         */
        //设置用uuid
        orderPO.setUserUuid(userUuid);
        //设置OrderNo
        Random r = new Random();
        Integer t = r.nextInt(9999);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = new Date();
        String orderNo = sdf.format(date) + t.toString();
        orderPO.setOrderNo(orderNo);
        //设置收货人信息
        PcCartReceiverInfoTO consigneeMessage = pcCartMapper.selectConsigneeMessage(body.getConsigneeUuid());
        if (consigneeMessage == null) {
            return ResponseEntitySupport.error(HttpStatus.FORBIDDEN, "收货人信息异常", "Consignee information is abnormal");
        }
        orderPO.setReceiverName(consigneeMessage.getName());
        orderPO.setReceiverAddress(consigneeMessage.getAddress());
        orderPO.setReceiverCity(consigneeMessage.getCity());
        orderPO.setZipCode(consigneeMessage.getZipCode());
        orderPO.setReceiverPhoneNumber(consigneeMessage.getPhone());
        orderPO.setReceiverDistrict(consigneeMessage.getDistrict());
        orderPO.setReceiverProvince(consigneeMessage.getProvince());
        //设置订单总金额
        BigDecimal total = pcCartMapper.selectOrderCartTotal(body.getCartCommodityUuidList());
        orderPO.setPayPrice(total);
        //生成订单信息
        pcCartMapper.insertOrder(orderPO);
        //生成订单商品信息
        for (String cartCommodityUuid : body.getCartCommodityUuidList()) {
            //生成订单珠宝信息
            OrderJewelryPO orderJewelryPO = new OrderJewelryPO();
            String cartJewelryUuid = pcCartMapper.selectCartJewelryUuid(cartCommodityUuid);
            orderJewelryPO.setCartJewelryUuid(cartJewelryUuid);
            orderJewelryPO.setOrderUuid(orderPO.getUuid());
            orderJewelryPO.setJewelryPrice(pcCartMapper.selectJewelryPrice(cartJewelryUuid));
            pcCartMapper.insertOrderJewelry(orderJewelryPO);
            pcCartMapper.updateCartStatusIsOrder("cart_jewelry", cartJewelryUuid);
            //订单商品信息
            OrderCommodityPO orderCommodityPO = new OrderCommodityPO();
            orderCommodityPO.setOrderUuid(orderPO.getUuid());
            orderCommodityPO.setCartCommodityUuid(cartCommodityUuid);
            orderCommodityPO.setOrderJewelryUuid(orderJewelryPO.getUuid());
            orderCommodityPO.setCommodityPrice(pcCartMapper.selectCommodityPrice(cartCommodityUuid));
            pcCartMapper.insertOrderCommodity(orderCommodityPO);
            pcCartMapper.updateCartStatusIsOrder("cart_commodity", cartCommodityUuid);
            //修改库存
            Integer storeCheck = pcCartMapper.updateCommodityStore(cartCommodityUuid);
            if (storeCheck == 0) {
                String commodityMessage=pcCartMapper.selectCartCommodityMessage(cartCommodityUuid);
                throw new storeException(commodityMessage);
            }
        }
        return ResponseEntitySupport.success();
    }
}
