package cn.ykthink.jewelry.model.comm.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * program: jewelry
 * description:订单PO
 * author: mi
 * create: 2019-05-05 19:06
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderPO extends BasePO{
    /**
     * 用户uuid
     */
    private String userUuid;
    /**
     * 收获人uuid
     */
    private String receiverUuid;
    /**
     * 订单状态
     */
    private Integer orderUuid;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 订单备注
     */
    private  String orderDescribe;
    /**
     * 支付金额
     */
    private BigDecimal payPrice;
    /**
     * 支付时间
     */
    private String payDate;
    /**
     * 物流公司名称
     */
    private String logisticsName;
    /**
     * 物流快递单号
     */
    private String logisticsNumber;
}
