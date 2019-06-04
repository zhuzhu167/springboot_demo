package cn.ykthink.jewelry.model.pc.order.vo;

import cn.ykthink.jewelry.model.common.vo.CommonCommodityInfoVO;
import cn.ykthink.jewelry.model.pc.commodity.vo.PcJewelryInfoVO;
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
    private List<CommonCommodityInfoVO> orderCommodityList;

    @ApiModelProperty(value = "订单钻石list", name = "orderJewelryList", dataType = "List", required = true)
    private List<PcJewelryInfoVO> orderJewelryList;

    @ApiModelProperty(value = "订单状态", name = "orderStatus", example = "1", dataType = "Integer", required = true)
    private Integer orderStatus;

    @ApiModelProperty(value = "订单编号", name = "orderNo", example = "12345", dataType = "String", required = true)
    private String orderNo;

    @ApiModelProperty(value = "订单备注", name = "orderDescribe", example = "货到付款", dataType = "String", required = false)
    private String orderDescribe;

    @ApiModelProperty(value = "支付总金额", name = "payPrice", example = "1314", dataType = "BigDecimal", required = true)
    private BigDecimal payPrice;

    @ApiModelProperty(value = "支付时间", name = "payDate", example = "2019-01-01 00:00:00", dataType = "String", required = true)
    private String payDate;

    @ApiModelProperty(value = "物流公司名称", name = "logisticsName", example = "顺丰", dataType = "String", required = true)
    private String logisticsName;

    @ApiModelProperty(value = "物流快递单号", name = "logisticNumber", example = "12345", dataType = "String", required = true)
    private String logisticsNumber;

    @ApiModelProperty(value = "物流快递状态", name = "logisticStatus", example = "1", dataType = "Integer", required = true)
    private String logisticsStatus;

    @ApiModelProperty(value = "收货人姓名", name = "receiverName", example = "name", dataType = "String", required = true)
    private String receiverName;

    @ApiModelProperty(value = "省份", name = "receiverProvince", example = "address", dataType = "String", required = true)
    private String receiverProvince;

    @ApiModelProperty(value = "城市", name = "receiverCity", example = "address", dataType = "String", required = true)
    private String receiverCity;

    @ApiModelProperty(value = "县", name = "receiverDistrict", example = "address", dataType = "String", required = true)
    private String receiverDistrict;

    @ApiModelProperty(value = "详细地址", name = "receiverAddress", example = "address", dataType = "String", required = true)
    private String receiverAddress;

    @ApiModelProperty(value = "收货人电话", name = "receiverPhoneNumber", example = "13711111110", dataType = "String", required = true)
    private String receiverPhoneNumber;

    @ApiModelProperty(value = "邮编", name = "zipCode", example = "52222", dataType = "String", required = true)
    private String zipCode;
}
