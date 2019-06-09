package cn.ykthink.jewelry.model.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * program: jewelry
 * description:图片VO
 * author: mi
 * create: 2019-05-17 16:53
 **/
@Data
public class CommonCommodityImageVO {
    @ApiModelProperty(value = "图片uuid", name = "imageUuid", example = "sdfsdf1231", dataType = "String", required = true)
    private String imageUuid;
    @ApiModelProperty(value = "图片url", name = "imageUrl", example = "qweasdzxc", dataType = "String", required = true)
    private String imageUrl;
}
