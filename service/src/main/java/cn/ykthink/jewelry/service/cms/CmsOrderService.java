package cn.ykthink.jewelry.service.cms;

import org.springframework.http.ResponseEntity;

/**
 * Author: YK
 * Title: CmsOrderService
 * Description: 商家订单service
 * Date: 2019/6/4
 * Time: 16:09
 */
public interface CmsOrderService {
    /**
     * 获取订单信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseEntity<Object> order(String orderNo,Integer pageNum, Integer pageSize);
}
