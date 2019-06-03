package cn.ykthink.jewelry.model.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * program: jewelry
 * description:商品简介VO
 * author: mi
 * create: 2019-05-14 17:33
 **/
@Data
public class CommonCommodityListVO {
    @ApiModelProperty(value = "商品uuid", name = "commodityUuid", example = "asd123", dataType = "String", required = true)
    private String commodityUuid;

    @ApiModelProperty(value = "图片list", name = "imageUuidList", example = "", dataType = "List", required = true)
    private List<CommonCommodityImageVO> imageList;

    @ApiModelProperty(value = "标题", name = "title", example = "钻戒", dataType = "String", required = true)
    private String title;

    @ApiModelProperty(value = "副标题", name = "subhead", example = "a123", dataType = "String", required = true)
    private String subhead;

    @ApiModelProperty(value = "商品售价", name = "commodityPrice", example = "123", dataType = "BigDecimal", required = true)
    private String commodityPrice;
}
