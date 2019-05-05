package cn.ykthink.jewelry.model.comm.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * program: jewelry
 * description:
 * author: mi
 * create: 2019-05-05 20:03
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class CartPO extends BasePO{
    /**
     * 用户uuid
     */
    private String userUuid;
    /**
     * 是否为订单（0-不是，1-是）
     */
    private Integer isOrder;
}
