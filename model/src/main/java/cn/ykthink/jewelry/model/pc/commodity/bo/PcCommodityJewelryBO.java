package cn.ykthink.jewelry.model.pc.commodity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Author: YK
 * Title: PcCommodityJewelryBO
 * Description: 加入购物车BO
 * Date: 2019/5/17
 * Time: 8:49
 */
@Data
public class PcCommodityJewelryBO {
    @NotBlank
    @ApiModelProperty(value = "商品uuid", name = "commodityUuid", example = "", dataType = "String", required = true)
    private String commodityUuid;
    @NotBlank
    @ApiModelProperty(value = "钻石uuid", name = "jewelryUuid", example = "", dataType = "String", required = true)
    private String jewelryUuid;
    @NotNull
    @ApiModelProperty(value = "尺寸", name = "size", example = "", dataType = "Integer", required = true)
    private Integer size;
}
