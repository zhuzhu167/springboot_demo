package cn.ykthink.jewelry.model.common.vo;

import cn.ykthink.jewelry.model.pc.user.vo.PcUserStoreVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * program: jewelry
 * description:商品VO
 * author: mi
 * create: 2019-05-09 15:24
 **/
@Data
public class CommonCommodityInfoVO {
    @ApiModelProperty(value = "商品uuid", name = "commodityUuid", example = "asd123", dataType = "String", required = true)
    private String commodityUuid;

    @ApiModelProperty(value = "类目uuid", name = "categoryUuid", example = "asd123", dataType = "String", required = true)
    private String categoryUuid;

    @ApiModelProperty(value = "剩余库存", name = "store", example = "120", dataType = "Integer", required = true)
    private Integer store;

    @ApiModelProperty(value = "标题", name = "title", example = "Diamond", dataType = "String", required = true)
    private String title;

    @ApiModelProperty(value = "副标题", name = "subhead", example = "made in China", dataType = "String", required = true)
    private String subhead;

    @ApiModelProperty(value = "价格", name = "commodityPrice", example = "1314", dataType = "BigDecimal", required = true)
    private BigDecimal commodityPrice;

    @ApiModelProperty(value = "材质uuid", name = "textureUuid", example = "111", dataType = "String", required = true)
    private String textureUuid;

    @ApiModelProperty(value = "材质", name = "textureName", example = "111", dataType = "String", required = true)
    private String textureName;

    @ApiModelProperty(value = "图片list", name = "imageList", example = "", dataType = "List", required = true)
    private List<CommonCommodityImageVO> imageList;

    @ApiModelProperty(value = "商品编号", name = "commodityNo", example = "007", dataType = "String", required = true)
    private String commodityNo;

    @ApiModelProperty(value = "商品详情", name = "detail", example = "qweasdzxc", dataType = "String", required = true)
    private String detail;
}
