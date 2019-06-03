package cn.ykthink.jewelry.model.common.po;

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
public class OrderPO extends BasePO {
    /**
     * 用户uuid
     */
    private String userUuid;
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
    private String orderDescribe;
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
    /**
     * 收货人姓名
     */
    private String receiverName;
    /**
     * 收货人手机号码
     */
    private String receiverPhoneNumber;
    /**
     * 收货人所在省份
     */
    private String receiverProvince;
    /**
     * 收货人所在城市
     */
    private String receiverCity;
    /**
     * 收货人所在区/县
     */
    private String receiverDistrict;
    /**
     * 收货人详细地址
     */
    private String receiverAddress;
    /**
     * 邮编
     */
    private String zipCode;

}
