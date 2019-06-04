package cn.ykthink.jewelry.orm.common;

import cn.ykthink.jewelry.model.common.vo.CommonCommodityInfoVO;
import cn.ykthink.jewelry.model.common.vo.CommonCommodityListVO;
import cn.ykthink.jewelry.model.common.vo.CommonJewelryListVO;
import cn.ykthink.jewelry.model.common.vo.CommonJewelryInfoVO;
import cn.ykthink.jewelry.model.common.vo.CommonCategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: YK
 * Title: CommodityMapper
 * Description: 公用商品Mapper
 * Date: 2019/6/3
 * Time: 23:52
 */
@Mapper
@Repository
public interface CommonCommodityMapper {
    /**
     * 商品列表
     * @return
     */
    List<CommonCommodityListVO> selectCommodityIntroduction(@Param("categoryUuid") String categoryUuid);


    /**
     * 商品详情
     * @param commodityUuid
     * @return
     */
    CommonCommodityInfoVO selectCommodity(@Param("commodityUuid") String commodityUuid);

    /**
     * 钻石列表
     *
     * @return
     */
    List<CommonJewelryListVO> selectJewelryIntroduction();

    /**
     * 钻石详情
     *
     * @param
     * @return*
     */
    CommonJewelryInfoVO selectJewelry(@Param("jewelryUuid") String jewelryUuid);

    /**
     * 类目信息
     *
     * @return
     */
    List<CommonCategoryVO> selectIndexCategory();

}
