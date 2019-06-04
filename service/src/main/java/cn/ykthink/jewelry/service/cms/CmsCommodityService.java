package cn.ykthink.jewelry.service.cms;

import org.springframework.http.ResponseEntity;

/**
 * Author: YK
 * Title: CmsCommodityService
 * Description: 商家商品控制器
 * Date: 2019/6/3
 * Time: 23:35
 */
public interface CmsCommodityService {
    /**
     * 商品列表
     *
     * @return
     */
    ResponseEntity<Object> commodityList(String categoryUuid, Integer pageNum, Integer pageSize);

    /**
     * 商品详情
     *
     * @return
     */
    ResponseEntity<Object> commodity(String commodityUuid);

    /**
     * 钻石列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseEntity<Object> jewelryList(Integer pageNum, Integer pageSize);

    /**
     * 钻石详情
     *
     * @param jewelryUuid
     * @return
     */
    ResponseEntity<Object> jewelryInfo(String jewelryUuid);
}
