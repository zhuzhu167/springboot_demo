package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.model.pc.cart.bo.PcUserPayCartBO;
import cn.ykthink.jewelry.model.pc.cart.vo.PcUserCartVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserReceiverInfoVO;
import cn.ykthink.jewelry.orm.pc.PcCartMapper;
import cn.ykthink.jewelry.orm.pc.PcUserMapper;
import cn.ykthink.jewelry.service.pc.PcCartService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

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
        String userUuid = JWTokenUtil.validateJWToken(JWTokenUtil.getRequestHeader("X-Access-Token"), "uuid");
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        JSONObject response = new JSONObject();
        List<PcUserCartVO> pcUserCartVOList = pcCartMapper.selectCart(userUuid);
        BigDecimal sumPrice = new BigDecimal("0");
        for(PcUserCartVO p:pcUserCartVOList){
            //获取购物车总价
            sumPrice = sumPrice.add(p.getPrice());
        }
        response.put("sumPrice",sumPrice);
        response.put("total", page.getTotal());
        response.put("response", page.getResult());
        return ResponseEntitySupport.success(response);
    }

    @Override
    public ResponseEntity<Object> removeCart(String cartCommodityUuid) {
        if (pcCartMapper.removeIsDeleted(cartCommodityUuid)>1){
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "数据异常", "Abnormal data");
        }
    }

    @Override
    public ResponseEntity<Object> payCart(PcUserPayCartBO body) {
        String userUuid = JWTokenUtil.validateJWToken(JWTokenUtil.getRequestHeader("X-Access-Token"), "uuid");
        List<PcUserReceiverInfoVO> consigneeMessage = pcCartMapper.selectConsigneeMessage(userUuid);
        if (consigneeMessage.get(0) != null){

        }
        return null;
    }
}
