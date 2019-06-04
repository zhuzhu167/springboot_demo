package cn.ykthink.jewelry.model.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: YK
 * Title: CommonCategoryVO
 * Description: 类目信息
 * Date: 2019/5/13
 * Time: 11:07
 */
@Data
public class CommonCategoryVO {
    @ApiModelProperty(value = "类目uuid", name = "categoryUuid", example = "1234", dataType = "String", required = true)
    private String categoryUuid;

    @ApiModelProperty(value = "类目名称", name = "categoryName", example = "1234", dataType = "String", required = true)
    private String categoryName;
}
