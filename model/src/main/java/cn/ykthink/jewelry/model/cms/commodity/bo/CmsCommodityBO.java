package cn.ykthink.jewelry.model.cms.commodity.bo;

import cn.ykthink.jewelry.model.common.vo.CommonCommodityImageVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * Author: YK
 * Title: CmsCommodityBO
 * Description: 添加商品BO
 * Date: 2019/6/4
 * Time: 20:58
 */
@Data
public class CmsCommodityBO {

    @ApiModelProperty(value = "图片list", name = "imageUuidList", example = "", dataType = "List", required = true)
    private List<CmsCommodityJewelryImageBO > imageList;
    @NotBlank
    @ApiModelProperty(value = "标题", name = "title", example = "钻戒", dataType = "String", required = true)
    private String title;
    @NotBlank
    @ApiModelProperty(value = "副标题", name = "subhead", example = "a123", dataType = "String", required = true)
    private String subhead;
    @NotNull
    @ApiModelProperty(value = "商品售价", name = "commodityPrice", example = "123", dataType = "BigDecimal", required = true)
    private BigDecimal commodityPrice;
    @NotBlank
    @ApiModelProperty(value = "材质uuid", name = "texture_uuid", example = "123", dataType = "String", required = true)
    private String textureUuid;
    @NotBlank
    @ApiModelProperty(value = "类目uuid", name = "category_uuid", example = "123", dataType = "String", required = false)
    private String categoryUuid;
    @NotBlank
    @ApiModelProperty(value = "商品详情", name = "detail", example = "123", dataType = "String", required = true)
    private String detail;
    @NotNull
    @ApiModelProperty(value = "库存", name = "store", example = "123", dataType = "Integer", required = true)
    private Integer store;
}
