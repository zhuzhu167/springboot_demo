package cn.ykthink.jewelry.model.pc.cart.vo;

import cn.ykthink.jewelry.model.common.vo.CommonCommodityInfoVO;
import cn.ykthink.jewelry.model.common.vo.CommonJewelryInfoVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * program: jewelry
 * description:购物车VO
 * author: mi
 * create: 2019-05-09 14:57
 **/
@Data
public class PcUserCartVO {
    @ApiModelProperty(value = "商品购物车uuid", name = "cartCommodityUuid", example = "1234", dataType = "String", required = true)
    private String cartCommodityUuid;

    @ApiModelProperty(value = "钻石购物车uuid", name = "cartJewelryUuid", example = "1234", dataType = "String", required = true)
    private String cartJewelryUuid;

    @ApiModelProperty(value = "购物车商品list", name = "cartCommodityList", dataType = "List", required = true)
    private List<CommonCommodityInfoVO> cartCommodityList;

    @ApiModelProperty(value = "购物车钻石list", name = "cartJewelryList", dataType = "List", required = true)
    private List<CommonJewelryInfoVO> cartJewelryList;

    @ApiModelProperty(value = "商品钻石总价", name = "price", dataType = "BigDecimal", required = true)
    private BigDecimal price;
}
