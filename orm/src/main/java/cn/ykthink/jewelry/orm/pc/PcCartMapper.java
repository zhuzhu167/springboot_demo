package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.pc.user.vo.PcUserCartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * program: jewelry
 * description:购物车Mapper
 * author: mi
 * create: 2019-05-26 19:57
 **/
@Mapper
@Repository
public interface PcCartMapper {
    /**
     * 购物车信息
     */
    List<PcUserCartVO> selectCart(@Param("cartCommodityUuid")String cartCommodityUuid);
}
