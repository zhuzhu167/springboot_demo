package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserOrderVO;
import cn.ykthink.jewelry.orm.pc.PcOrderMapper;
import cn.ykthink.jewelry.service.pc.PcOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        return ResponseEntitySupport.success(new PcUserOrderVO());
    }

    @Override
    public ResponseEntity<Object> pay(String orderUuid) {
        /**
         * 相关支付操作
         */
        if (pcOrderMapper.updateOrderStatus(orderUuid, 1) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "数据异常", "Abnormal data");
        }

    }
}
