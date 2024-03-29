package cn.ykthink.jewelry.service.pc;

import cn.ykthink.jewelry.model.pc.commodity.bo.PcCommodityJewelryBO;
import org.springframework.http.ResponseEntity;

/**
 * program: jewelry
 * description:商品Service
 * author: mi
 * create: 2019-05-14 17:40
 **/
public interface PcCommodityService {

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

    /**
     * 加入购物车
     *
     * @param body
     * @return
     */
    ResponseEntity<Object> commodityJewelry(PcCommodityJewelryBO body);
}
