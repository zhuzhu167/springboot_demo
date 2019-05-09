package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * program: jewelry
 * description:商品VO
 * author: mi
 * create: 2019-05-09 15:24
 **/
@Data
public class PcUserCommodityInfoVO {
    @ApiModelProperty(value = "商品uuid", name = "commodityUuid", example = "asd123", dataType = "String", required = true)
    private String commodityUuid;

    @ApiModelProperty(value = "标题", name = "title", example = "Diamond", dataType = "String", required = true)
    private String title;

    @ApiModelProperty(value = "副标题", name = "subhead", example = "made in China", dataType = "String", required = true)
    private String subhead;

    @ApiModelProperty(value = "价格", name = "commodityPrice", example = "1314", dataType = "BigDecimal", required = true)
    private BigDecimal price;

    @ApiModelProperty(value = "材质", name = "texture", example = "gold", dataType = "String", required = true)
    private String texture;

    @ApiModelProperty(value = "库存", name = "storeTotal", example = "20", dataType = "Integer", required = true)
    private Integer storeTotal;

    @ApiModelProperty(value = "尺寸", name = "size", example = "8", dataType = "Integer", required = true)
    private Integer size;

    @ApiModelProperty(value = "图片", name = "imageUrl", example = "www.xxx.com/abcde.jpg", dataType = "String", required = true)
    private String imageUrl;

    @ApiModelProperty(value = "商品编号", name = "commodityNo", example = "007", dataType = "String", required = true)
    private String commodityNo;

    @ApiModelProperty(value = "商品详情", name = "detail", example = "qweasdzxc", dataType = "String", required = true)
    private String detail;
}
