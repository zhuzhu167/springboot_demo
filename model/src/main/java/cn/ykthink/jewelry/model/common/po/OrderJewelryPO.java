package cn.ykthink.jewelry.model.common.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * program: jewelry
 * description:订单钻石PO
 * author: mi
 * create: 2019-05-05 18:51
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderJewelryPO extends BasePO{
    /**
     * 订单uuid
     */
    private String orderUuid;
    /**
     * 购物车钻石uuid
     */
    private String cartJewelryUuid;
    /**
     * 钻石售价
     */
    private BigDecimal jewelryPrice;
}
