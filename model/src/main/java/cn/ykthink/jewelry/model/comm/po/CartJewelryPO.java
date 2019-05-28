package cn.ykthink.jewelry.model.comm.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * program: jewelry
 * description:购物车钻石PO
 * author: mi
 * create: 2019-05-05 19:50
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class CartJewelryPO extends BasePO{
    /**
     * 钻石uuid
     */
    private String jewelryUuid;
    /**
     * 钻石编号
     */
    private String jewelryNo;
    /**
     * 形状
     */
    private String shape;
    /**
     * 颜色
     */
    private String color;
    /**
     * 净度
     */
    private String clarity;
    /**
     * 切工
     */
    private String cut;
    /**
     * 抛光
     */
    private String polishing;
    /**
     * 荧光
     */
    private String light;
    /**
     * 用户uuid
     */
    private String userUuid;

}
