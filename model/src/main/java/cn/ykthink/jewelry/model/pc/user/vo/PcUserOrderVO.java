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

    @ApiModelProperty(value = "订单商品list", name = "orderCommodityVOList", dataType = "List", required = true)
    private List<PcUserOrderCommodityVO> orderCommodityVOList;
}
