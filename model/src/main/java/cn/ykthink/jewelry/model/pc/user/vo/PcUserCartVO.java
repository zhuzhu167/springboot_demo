package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

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

    @ApiModelProperty(value = "图片", name = "imageUrl", example = "www.xxx.com/abcdefg.jpg", dataType = "String", required = true)
    private String image_url;

    @ApiModelProperty(value = "标题", name = "title", example = "Diamond", dataType = "String", required = true)
    private String title;

    @ApiModelProperty(value = "价格", name = "price", example = "1314", dataType = "BigDecimal", required = true)
    private BigDecimal price;

}
