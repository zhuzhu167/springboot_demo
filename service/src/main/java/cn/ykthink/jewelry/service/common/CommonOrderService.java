package cn.ykthink.jewelry.service.common;

import net.sf.json.JSONObject;

/**
 * Author: YK
 * Title: CommonOrderService
 * Description: 公用订单Service
 * Date: 2019/6/4
 * Time: 16:06
 */
public interface CommonOrderService {
    /**
     * 获取订单信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    JSONObject order(String userUuid,String orderNo,Integer pageNum, Integer pageSize);
}
