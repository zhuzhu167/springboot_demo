package cn.ykthink.jewelry.model.comm.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * program: jewelry
 * description:购物车商品PO
 * author: mi
 * create: 2019-05-05 19:58
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class CartCommodityPO extends BasePO{
    /**
     * 订单uuid
     */
    private String orderUuid;
    /**
     * 商品uuid
     */
    private String commodityUuid;
    /**
     * 材质uuid
     */
    private String textureUuid;
    /**
     * 购物车钻石uuid
     */
    private String cartJewelryUuid;
    /**
     * 钻石编号
     */
    private String jewelryNo;
    /**
     * 尺寸
     */
    private Integer size;
    /**
     * 是否为订单（0-不是，1-是）
     */
    private Integer isOrder;

}
