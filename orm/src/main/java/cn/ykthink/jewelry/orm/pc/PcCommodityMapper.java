package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.common.po.CartCommodityPO;
import cn.ykthink.jewelry.model.common.po.CartJewelryPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * program: jewelry
 * description:商品Mapper
 * author: mi
 * create: 2019-05-14 17:58
 **/
@Mapper
@Repository
public interface PcCommodityMapper {


    /**
     * 钻石加入购物车
     */
    Integer insertJewelry(CartJewelryPO cartJewelryPO);

    /**
     * 商品加入购物车
     */
    Integer insertCommodity(CartCommodityPO cartCommodityPO);
}
