package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * program: jewelry
 * description:商品简介VO
 * author: mi
 * create: 2019-05-14 17:33
 **/
@Data
public class PcUserCommodityIntroductionVO {
    @ApiModelProperty(value = "商品uuid", name = "commodityUuid", example = "asd123", dataType = "String", required = true)
    private String commodityUuid;

    @ApiModelProperty(value = "图片", name = "image_url", example = "www.123.com/4321.jpg", dataType = "String", required = true)
    private String image_url;

    @ApiModelProperty(value = "标题", name = "title", example = "钻戒", dataType = "String", required = true)
    private String title;

    @ApiModelProperty(value = "副标题", name = "subhead", example = "a123", dataType = "String", required = true)
    private String subhead;

    @ApiModelProperty(value = "商品售价", name = "commodityPrice", example = "123", dataType = "BigDecimal", required = true)
    private String commodityPrice;
}
