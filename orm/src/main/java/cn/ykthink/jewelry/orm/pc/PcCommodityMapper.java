package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.comm.po.CartCommodityPO;
import cn.ykthink.jewelry.model.comm.po.CartJewelryPO;
import cn.ykthink.jewelry.model.pc.commodity.vo.PcCommodityInfoVO;
import cn.ykthink.jewelry.model.pc.commodity.vo.PcCommodityIntroductionVO;
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
     * 商品列表
     * @return
     */
    List<PcCommodityIntroductionVO> selectCommodityIntroduction();

    /**
     * 商品详情
     * @param commodityUuid
     * @return
     */
    PcCommodityInfoVO selectCommodity(@Param("commodityUuid") String commodityUuid);

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
