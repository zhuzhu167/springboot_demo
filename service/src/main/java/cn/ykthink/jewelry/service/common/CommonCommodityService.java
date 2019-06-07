package cn.ykthink.jewelry.service.common;

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
    Object commodityList(String categoryUuid,Integer commodityStatus, Integer pageNum, Integer pageSize);

    /**
     * 商品详情
     *
     * @return
     */
    Object commodity(String commodityUuid);

    /**
     * 钻石列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    Object jewelryList(Integer pageNum, Integer pageSize);

    /**
     * 钻石详情
     *
     * @param jewelryUuid
     * @return
     */
    Object jewelryInfo(String jewelryUuid);

    /**
     * 类目列表
     * @return
     */
    Object category();
}
