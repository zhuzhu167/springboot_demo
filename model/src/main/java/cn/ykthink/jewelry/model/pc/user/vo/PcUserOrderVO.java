package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * program: jewelry
 * description:订单VO
 * author: mi
 * create: 2019-05-09 15:21
 **/
@Data
public class PcUserOrderVO {
    @ApiModelProperty(value = "订单uuid", name = "orderUuid", example = "12345", dataType = "String", required = true)
    private String orderUuid;

    @ApiModelProperty(value = "订单商品list", name = "orderCommodityList", dataType = "List", required = true)
    private List<PcUserOrderCommodityVO> orderCommodityList;

    @ApiModelProperty(value = "订单状态", name = "orderStatus", example = "1", dataType = "Integer", required = true)
    private Integer orderStatus;

    @ApiModelProperty(value = "订单编号", name = "orderNo", example = "12345", dataType = "String", required = true)
    private String orderNo;

    @ApiModelProperty(value = "订单备注", name = "orderDescribe", example = "货到付款", dataType = "String", required = false)
    private String orderDescribe;

    @ApiModelProperty(value = "支付总金额", name = "payTotalPrice", example = "1314", dataType = "BigDecimal", required = true)
    private BigDecimal payTotalPrice;

    @ApiModelProperty(value = "支付时间", name = "payDate", example = "2019-01-01 00:00:00", dataType = "String", required = true)
    private String payDate;

    @ApiModelProperty(value = "物流公司名称", name = "logisticsName", example = "顺丰", dataType = "String", required = true)
    private String logisticsName;

    @ApiModelProperty(value = "物流快递单号", name = "logisticNumber", example = "12345", dataType = "String", required = true)
    private String logisticNumber;
}
