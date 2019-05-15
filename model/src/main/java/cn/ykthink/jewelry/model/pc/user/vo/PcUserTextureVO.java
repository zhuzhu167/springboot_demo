package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * program: jewelry
 * description:材质VO
 * author: mi
 * create: 2019-05-15 20:34
 **/
@Data
public class PcUserTextureVO {
    @ApiModelProperty(value = "材质uuid", name = "textureUuid", example = "1234", dataType = "String", required = true)
    private String textureUuid;

    @ApiModelProperty(value = "材质名称", name = "textureName", example = "name", dataType = "String", required = true)
    private String textureName;
}
