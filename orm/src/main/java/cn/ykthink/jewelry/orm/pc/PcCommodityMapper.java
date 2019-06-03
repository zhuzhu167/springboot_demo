package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.common.po.CartCommodityPO;
import cn.ykthink.jewelry.model.common.po.CartJewelryPO;
import cn.ykthink.jewelry.model.common.vo.CommonCommodityInfoVO;
import cn.ykthink.jewelry.model.pc.commodity.vo.PcJewelryInfoVO;
import cn.ykthink.jewelry.model.pc.commodity.vo.PcJewelryIntroductionVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
     * 商品详情
     * @param commodityUuid
     * @return
     */
    CommonCommodityInfoVO selectCommodity(@Param("commodityUuid") String commodityUuid);

    /**
     * 钻石列表
     * @return
     */
    List<PcJewelryIntroductionVO> selectJewelryIntroduction();

    /**
     * 钻石详情
     * @param
     * @return*
     */
    PcJewelryInfoVO selectJewelry(@Param("jewelryUuid") String jewelryUuid);

    /**
     * 钻石加入购物车
     */
    Integer insertJewelry(CartJewelryPO cartJewelryPO);

    /**
     * 商品加入购物车
     */
    Integer insertCommodity(CartCommodityPO cartCommodityPO);
}
