package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.model.pc.order.vo.PcUserOrderVO;
import cn.ykthink.jewelry.orm.pc.PcOrderMapper;
import cn.ykthink.jewelry.service.pc.PcOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * program: jewelry
 * description:PC订单Service实现类
 * author: mi
 * create: 2019-05-09 16:53
 **/
@Service
public class PcOrderServiceImpl implements PcOrderService {
    @Resource
    PcOrderMapper pcOrderMapper;


    @Override
    public ResponseEntity<Object> order(Integer pageNum, Integer pageSize) {
        String userUuid = JWTokenUtil.getJWTokenUuid();
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        JSONObject response = new JSONObject();
        pcOrderMapper.selectOrder(userUuid);
        response.put("total", page.getTotal());
        response.put("response", page.getResult());
        return ResponseEntitySupport.success(response);
    }

    @Override
    public ResponseEntity<Object> pay(String orderUuid) {
        /**
         * 相关支付操作
         */
        if (pcOrderMapper.updateOrderStatus(orderUuid, 1) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
        }
    }

    @Override
    public ResponseEntity<Object> removeIsDeleted(String orderUuid) {
        if (pcOrderMapper.checkLogisticsStatus(orderUuid) > 0){
            if (pcOrderMapper.removeIsDeleted(orderUuid) > 0) {
                return ResponseEntitySupport.success();
            } else {
                return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
            }
        }else{
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "订单未确认收货", "The receipt of the order is not confirmed");
        }
    }

    @Override
    public ResponseEntity<Object> updateLogisticsStatus(String orderUuid) {
        if (pcOrderMapper.updateLogisticsStatus(orderUuid)> 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
        }
    }
}
