package cn.ykthink.jewelry.model.pc.commodity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * program: jewelry
 * description:图片VO
 * author: mi
 * create: 2019-05-15 16:48
 **/
@Data
public class PcCommodityImageVO {

    @ApiModelProperty(value = "图片路径", name = "imageUrl", example = "1234", dataType = "String", required = true)
    private String imageUrl;

}
