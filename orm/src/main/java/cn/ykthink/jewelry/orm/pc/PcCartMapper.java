package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.pc.cart.vo.PcUserCartVO;
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
    List<PcUserCartVO> selectCart(@Param("userUuid") String userUuid);

    /**
     * 删除购物车
     */
    Integer removeIsDeleted(@Param("cartCommodityUuid") String cartCommodityUuid);

    /**
     * 购买
     */
}
