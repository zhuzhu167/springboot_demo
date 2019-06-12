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

    @ApiModelProperty(value = "类目名称", name = "categoryName", example = "结婚钻戒", dataType = "String", required = true)
    private String categoryName;

    @ApiModelProperty(value = "文案", name = "copywriting", example = "文案", dataType = "String", required = true)
    private String copywriting;

    @ApiModelProperty(value = "排序", name = "sort", example = "123", dataType = "String", required = true)
    private Integer sort;
}
