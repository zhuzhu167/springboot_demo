package cn.ykthink.jewelry.model.cms.commodity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Author: YK
 * Title: CmsTextureListVO
 * Description: 商家材质VO
 * Date: 2019/6/5
 * Time: 15:02
 */
@Data
public class CmsTextureListVO {
    @ApiModelProperty(value = "材质uuid", name = "uuid", example = "a123", dataType = "String", required = true)
    private String uuid;
    @ApiModelProperty(value = "材质名称", name = "texture", example = "a123", dataType = "String", required = true)
    private String textureName;
}
