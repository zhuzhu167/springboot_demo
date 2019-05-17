package cn.ykthink.jewelry.model.pc.commodity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Author: YK
 * Title: PcCommodityJewelryInfoVO
 * Description: 砖石vo
 * Date: 2019/5/17
 * Time: 8:20
 */
@Data
public class PcJewelryInfoVO {
    @ApiModelProperty(value = "钻石编号", name = "jewelryNo", example = "a123", dataType = "String", required = true)
    private String jewelryNo;

    @ApiModelProperty(value = "形状", name = "shape", example = "a123", dataType = "String", required = true)
    private String shape;

    @ApiModelProperty(value = "颜色", name = "color", example = "a123", dataType = "String", required = true)
    private String color;

    @ApiModelProperty(value = "净度", name = "clarity", example = "a123", dataType = "String", required = true)
    private String clarity;

    @ApiModelProperty(value = "切工", name = "cut", example = "a123", dataType = "String", required = true)
    private String cut;

    @ApiModelProperty(value = "抛光", name = "polishing", example = "a123", dataType = "String", required = true)
    private String polishing;

    @ApiModelProperty(value = "莹光", name = "light", example = "a123", dataType = "String", required = true)
    private String light;

    @ApiModelProperty(value = "价格", name = "jewelryPrice", example = "a123", dataType = "jewelryPrice", required = true)
    private BigDecimal jewelryPrice;

    @ApiModelProperty(value = "图片list", name = "imageUuidList", example = "", dataType = "List", required = true)
    private List<PcCommodityImageVO> imageList;
}
