package cn.ykthink.jewelry.model.pc.commodity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * program: jewelry
 * description:图片VO
 * author: mi
 * create: 2019-05-17 16:53
 **/
@Data
public class PcCommodityImageVO {
    @ApiModelProperty(value = "图片url", name = "imageUrl", example = "qweasdzxc", dataType = "String", required = true)
    private String imageUrl;
}
