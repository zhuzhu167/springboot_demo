package cn.ykthink.jewelry.model.cms.commodity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Author: YK
 * Title: CmsCategoryBO
 * Description: 类目BO
 * Date: 2019/6/5
 * Time: 15:15
 */
@Data
public class CmsCategoryBO {
    @NotBlank
    @ApiModelProperty(value = "类目名称", name = "category", example = "123", dataType = "String", required = true)
    private String category;
    @NotBlank
    @ApiModelProperty(value = "文案", name = "copywriting", example = "123", dataType = "String", required = true)
    private String copywriting;
    @NotBlank
    @ApiModelProperty(value = "排序", name = "sort", example = "123", dataType = "Integer", required = true)
    private Integer sort;
}
