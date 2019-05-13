package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * program: jewelry
 * description:购物车VO
 * author: mi
 * create: 2019-05-09 14:57
 **/
@Data
public class PcUserCartVO {
    @ApiModelProperty(value = "购物车uuid", name = "cartUuid", example = "12345", dataType = "String", required = true)
    private String cartUuid;

    @ApiModelProperty(value = "购物车商品list", name = "cartCommodityVOList", dataType = "List", required = true)
    private List<PcUserCartCommodityVO> cartCommodityVOList;
}
