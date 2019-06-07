package cn.ykthink.jewelry.model.cms.commodity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * Author: YK
 * Title: CmsJewelryBO
 * Description: 钻石bo
 * Date: 2019/6/7
 * Time: 23:59
 */
@Data
public class CmsJewelryBO {
    @NotBlank
    @ApiModelProperty(value = "形状", name = "shape", example = "a123", dataType = "String", required = true)
    private String shape;
    @NotBlank
    @ApiModelProperty(value = "颜色", name = "color", example = "a123", dataType = "String", required = true)
    private String color;
    @NotBlank
    @ApiModelProperty(value = "净度", name = "clarity", example = "a123", dataType = "String", required = true)
    private String clarity;
    @NotBlank
    @ApiModelProperty(value = "切工", name = "cut", example = "a123", dataType = "String", required = true)
    private String cut;
    @NotBlank
    @ApiModelProperty(value = "抛光", name = "polishing", example = "a123", dataType = "String", required = true)
    private String polishing;
    @NotBlank
    @ApiModelProperty(value = "莹光", name = "light", example = "a123", dataType = "String", required = true)
    private String light;
    @NotNull
    @ApiModelProperty(value = "价格", name = "jewelryPrice", example = "123", dataType = "BigDecimal", required = true)
    private BigDecimal jewelryPrice;

    @ApiModelProperty(value = "图片list", name = "imageUuidList", example = "", dataType = "List", required = true)
    private List<CmsCommodityJewelryImageBO> imageList;

}
