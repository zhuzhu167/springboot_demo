package cn.ykthink.jewelry.model.pc.user.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Author: YK
 * Title: PcUserInsertConsigneeBO
 * Description: 新增收货人信息
 * Date: 2019/5/13
 * Time: 8:58
 */
@Data
public class PcUserInsertConsigneeBO {
    @NotBlank
    @ApiModelProperty(value = "收货人名称", name = "name", example = "", dataType = "String", required = false)
    private String name;
    @NotBlank
    @ApiModelProperty(value = "收货人手机", name = "phone", example = "", dataType = "String", required = false)
    private String phone;
    @NotBlank
    @ApiModelProperty(value = "收货人县区", name = "district", example = "", dataType = "String", required = false)
    private String district;
    @NotBlank
    @ApiModelProperty(value = "收货人城市", name = "city", example = "", dataType = "String", required = false)
    private String city;
    @NotBlank
    @ApiModelProperty(value = "收货人省份", name = "province", example = "", dataType = "String", required = false)
    private String province;
    @NotBlank
    @ApiModelProperty(value = "收货人详细地址", name = "address", example = "", dataType = "String", required = false)
    private String address;
    @NotBlank
    @ApiModelProperty(value = "收货人邮编", name = "zipCode", example = "", dataType = "String", required = false)
    private String zipCode;
}
