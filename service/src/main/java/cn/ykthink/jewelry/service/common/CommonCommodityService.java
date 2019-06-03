package cn.ykthink.jewelry.service.common;

import org.springframework.http.ResponseEntity;

/**
 * Author: YK
 * Title: CommonCommodityService
 * Description: 商品Service
 * Date: 2019/6/3
 * Time: 23:49
 */
public interface CommonCommodityService {
    /**
     * 商品列表
     *
     * @return
     */
    ResponseEntity<Object> commodityList(String categoryUuid, Integer pageNum, Integer pageSize);
}
