package cn.ykthink.jewelry.model.cms.commodity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: YK
 * Title: CmsCategoryBO
 * Description: 类目BO
 * Date: 2019/6/5
 * Time: 15:15
 */
@Data
public class CmsCategoryBO {
    @ApiModelProperty(value = "类目名称", name = "category", example = "123", dataType = "String", required = true)
    private String category;
    @ApiModelProperty(value = "文案", name = "copywriting", example = "123", dataType = "String", required = true)
    private String copywriting;
    @ApiModelProperty(value = "排序", name = "sort", example = "123", dataType = "Integer", required = true)
    private Integer sort;
}
