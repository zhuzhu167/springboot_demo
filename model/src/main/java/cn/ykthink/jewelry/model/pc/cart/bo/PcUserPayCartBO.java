package cn.ykthink.jewelry.model.pc.cart.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * program: jewelry
 * description:PC购物车付款BO
 * author: mi
 * create: 2019-05-31 13:56
 **/
@Data
public class PcUserPayCartBO {
    @ApiModelProperty(value = "商品购物车uuidList", name = "cartCommodityUuidList", example = "", dataType = "List", required = true)
    private List<String> cartCommodityUuidList;
    @ApiModelProperty(value = "收货人信息Uuid", name = "consigneeUuid", example = "", dataType = "String", required = true)
    private String consigneeUuid;

}
