package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.pc.commodity.vo.PcCommodityInfoVO;
import cn.ykthink.jewelry.model.pc.commodity.vo.PcCommodityIntroductionVO;
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
}
