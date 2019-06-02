package cn.ykthink.jewelry.orm.pc;

import cn.ykthink.jewelry.model.comm.po.OrderCommodityPO;
import cn.ykthink.jewelry.model.comm.po.OrderJewelryPO;
import cn.ykthink.jewelry.model.comm.po.OrderPO;
import cn.ykthink.jewelry.model.pc.cart.to.PcCartReceiverInfoTO;
import cn.ykthink.jewelry.model.pc.cart.vo.PcUserCartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
     *
     * @param userUuid
     * @return
     */
    List<PcUserCartVO> selectCart(@Param("userUuid") String userUuid);

    /**
     * 删除购物车
     *
     * @param cartCommodityUuid
     * @return
     */
    Integer removeIsDeleted(@Param("cartCommodityUuid") String cartCommodityUuid);

    /**
     * 获取收货人信息
     *
     * @param uuid
     * @return
     */
    PcCartReceiverInfoTO selectConsigneeMessage(@Param("uuid") String uuid);

    /**
     * 设置购物车内商品为订单
     *
     * @param cartCommodityUuid
     * @return
     */
    Integer updateCart(@Param("cartCommodityUuid") String cartCommodityUuid);

    /**
     * 查询购物车总价
     *
     * @param cartCommodityUuidList
     * @return
     */
    BigDecimal selectOrderCartTotal(@Param("cartCommodityUuidList") List<String> cartCommodityUuidList);

    /**
     * 生成订单信息
     *
     * @param orderPO
     * @return
     */
    Integer insertOrder(OrderPO orderPO);

    /**
     * 查询购物车珠宝uuid
     *
     * @param cartCommodityUuid
     * @return
     */
    String selectCartJewelryUuid(@Param("cartCommodityUuid") String cartCommodityUuid);

    /**
     * 查询珠宝价格
     *
     * @param cartJewelryUuid
     * @return
     */
    BigDecimal selectJewelryPrice(@Param("cartJewelryUuid") String cartJewelryUuid);

    /**
     * 查询商品价格
     *
     * @param cartCommodityUuid
     * @return
     */
    BigDecimal selectCommodityPrice(@Param("cartCommodityUuid") String cartCommodityUuid);

    /**
     * 插入订单珠宝信息
     *
     * @param orderJewelryPO
     * @return
     */
    Integer insertOrderJewelry(OrderJewelryPO orderJewelryPO);

    /**
     * 更新购物车订单状态
     *
     * @param table
     * @param uuid
     * @return
     */
    Integer updateCartStatusIsOrder(@Param("table") String table, @Param("uuid") String uuid);

    /**
     * 插入订单商品信息
     *
     * @param orderCommodityPO
     * @return
     */
    Integer insertOrderCommodity(OrderCommodityPO orderCommodityPO);

    /**
     * 检测购物车中商品是否生成过订单
     *
     * @param cartCommodityUuidList
     * @return
     */
    Integer checkCart(@Param("cartCommodityUuidList") List<String> cartCommodityUuidList);
}
