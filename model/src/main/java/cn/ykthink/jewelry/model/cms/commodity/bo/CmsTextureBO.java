package cn.ykthink.jewelry.model.cms.commodity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: YK
 * Title: CmsTextureBO
 * Description: 商家材质BO
 * Date: 2019/6/5
 * Time: 15:02
 */
@Data
public class CmsTextureBO {
    @ApiModelProperty(value = "材质名称", name = "texture", example = "a123", dataType = "String", required = true)
    private String textureName;
}
