package cn.ykthink.jewelry.model.cms.commodity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: YK
 * Title: CmsShelfCommodityBO
 * Description: 上下架商品
 * Date: 2019/6/4
 * Time: 21:15
 */
@Data
public class CmsShelfCommodityBO {
    @ApiModelProperty(value = "商品状态（0-下架，1-上架）", name = "commodityStatus", example = "", dataType = "Integer", required = true)
    private Integer commodityStatus;
}
