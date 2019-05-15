package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.pc.user.vo.PcUserCommodityInfoVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserCommodityIntroductionVO;
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
    List<PcUserCommodityIntroductionVO> selectCommodityIntroduction();

    /**
     * 商品详情
     * @param commodityUuid
     * @return
     */
    PcUserCommodityInfoVO selectCommodity(@Param("commodityUuid") String commodityUuid);
}
