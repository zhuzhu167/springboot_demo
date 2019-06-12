package cn.ykthink.jewelry.model.cms.commodity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @ApiModelProperty(value = "类目名称", name = "categoryName", example = "123", dataType = "String", required = true)
    private String categoryName;
    @NotBlank
    @ApiModelProperty(value = "文案", name = "copywriting", example = "123", dataType = "String", required = true)
    private String copywriting;
    @NotNull
    @ApiModelProperty(value = "排序", name = "sort", example = "123", dataType = "Integer", required = true)
    private Integer sort;
}
