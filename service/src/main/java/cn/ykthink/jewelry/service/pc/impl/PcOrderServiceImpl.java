package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserOrderVO;
import cn.ykthink.jewelry.service.pc.PcOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * program: jewelry
 * description:PC订单Service实现类
 * author: mi
 * create: 2019-05-09 16:53
 **/
@Service
public class PcOrderServiceImpl implements PcOrderService {
    @Override
    public ResponseEntity<Object> order(Integer pageNum, Integer pageSize) {
        return ResponseEntitySupport.success(new PcUserOrderVO());
    }
}
