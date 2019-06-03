package cn.ykthink.jewelry.service.pc;

import org.springframework.http.ResponseEntity;

/**
 * program: jewelry
 * description:PC用户订单Service
 * author: mi
 * create: 2019-05-09 16:55
 **/
public interface PcOrderService {
    /**
     * 获取订单信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseEntity<Object> order(Integer pageNum, Integer pageSize);

    /**
     * 付款
     * @param orderUuid
     * @return
     */
    ResponseEntity<Object> pay(String orderUuid);

    /**
     * 删除订单
     * @param orderUuid
     * @return
     */
    ResponseEntity<Object> removeIsDeleted(String orderUuid);
}
