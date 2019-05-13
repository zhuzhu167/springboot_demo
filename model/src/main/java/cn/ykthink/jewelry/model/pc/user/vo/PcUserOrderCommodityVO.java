package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * program: jewelry
 * description:订单商品VO
 * author: mi
 * create: 2019-05-09 20:23
 **/
@Data
public class PcUserOrderCommodityVO {
    @ApiModelProperty(value = "订单商品uuid", name = "orderCommodityUuid", example = "1234", dataType = "String", required = true)
    private String orderCommodityUuid;

    @ApiModelProperty(value = "图片", name = "imageUrl", example = "www.xxx.com/abcdefg.jpg", dataType = "String", required = true)
    private String imageUrl;

    @ApiModelProperty(value = "标题", name = "title", example = "Diamond", dataType = "String", required = true)
    private String title;

    @ApiModelProperty(value = "支付金额", name = "payPrice", example = "1314", dataType = "BigDecimal", required = true)
    private BigDecimal payPrice;


}
