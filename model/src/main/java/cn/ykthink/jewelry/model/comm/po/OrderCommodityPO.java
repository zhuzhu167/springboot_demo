package cn.ykthink.jewelry.model.comm.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * program: jewelry
 * description:订单商品PO
 * author: mi
 * create: 2019-05-05 18:59
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderCommodityPO extends BasePO{
    /**
     * 商品uuid
     */
    private String commodityUuid;
    /**
     * 购物车uuid
     */
    private String cartUuid;
    /**
     * 购物车商品uuid
     */
    private String cartCommodityUuid;
    /**
     * 订单uuid
     */
    private String orderUuid;
    /**
     * 订单钻石uuid
     */
    private String orderJewelryUuid;
    /**
     * 商品售价
     */
    private BigDecimal commodityPrive;
}
