package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.pc.cart.vo.PcUserCartVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserReceiverInfoVO;
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
     * 查看购物车信息
     * @param userUuid
     * @return
     */
    List<PcUserCartVO> selectCart(@Param("userUuid") String userUuid);

    /**
     * 删除购物车
     * @param cartCommodityUuid
     * @return
     */
    Integer removeIsDeleted(@Param("cartCommodityUuid") String cartCommodityUuid);

    /**
     * 获取收货人信息
     * @param userUuid
     * @return
     */
    List<PcUserReceiverInfoVO> selectConsigneeMessage(@Param("userUuid") String userUuid);

    /**
     * 设置购物车内商品为订单
     * @param cartCommodityUuid
     * @return
     */
    Integer updateCart(@Param("cartCommodityUuid")String cartCommodityUuid);
}
