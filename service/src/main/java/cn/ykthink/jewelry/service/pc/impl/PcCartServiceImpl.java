package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserCartVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * program: jewelry
 * description:PC购物车Service实现类
 * author: mi
 * create: 2019-05-09 17:00
 **/
@Service
public class PcCartServiceImpl implements PcCartService{
    @Override
    public ResponseEntity<Object> cart(Integer pageNum, Integer pageSize) {
        return ResponseEntitySupport.success(new PcUserCartVO());
    }
}
