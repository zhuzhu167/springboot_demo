package cn.ykthink.jewelry.service.cms.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.service.cms.CmsOrderService;
import cn.ykthink.jewelry.service.common.CommonOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: YK
 * Title: CmsOrderImpl
 * Description: 商家订单impl
 * Date: 2019/6/4
 * Time: 16:09
 */
@Service
public class CmsOrderServiceImpl implements CmsOrderService {
    @Resource
    CommonOrderService commonOrderService;

    @Override
    public ResponseEntity<Object> order(String orderNo, Integer pageNum, Integer pageSize) {
        return ResponseEntitySupport.success(commonOrderService.order(null, orderNo, pageNum, pageSize));
    }
}
