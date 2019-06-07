package cn.ykthink.jewelry.model.cms.commodity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * program: jewelry
 * description:图片VO
 * author: mi
 * create: 2019-05-17 16:53
 **/
@Data
public class CmsCommodityJewelryImageBO {
    @ApiModelProperty(value = "图片uuid(新增图片无需填写，修改某张图片时填写)", name = "imageUuid", example = "fsadfesdf234sdf324", dataType = "String", required = false)
    private String imageUuid;
    @NotBlank
    @ApiModelProperty(value = "图片url", name = "imageUrl", example = "qweasdzxc", dataType = "String", required = true)
    private String imageUrl;
    @NotNull
    @ApiModelProperty(value = "图片排序", name = "sort", example = "qweasdzxc", dataType = "sort", required = true)
    private Integer sort;
}
