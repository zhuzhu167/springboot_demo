package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.pc.user.vo.PcUserCommodityIntroductionVO;
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
     * 商品列表
     * @return
     */
    PcUserCommodityIntroductionVO selectCommodityIntroduction();
}
