package cn.ykthink.jewelry.model.pc.user.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Author: YK
 * Title: PcUserLoginBO
 * Description:
 * Date: 2019/3/14
 * Time: 22:33
 */
@Data
public class PcUserLoginBO {
    @NotBlank(message = "Account cannot be empty")
    @ApiModelProperty(value = "账号", name = "account", example = "", dataType = "String", required = true)
    private String account;

    @NotBlank(message = "password cannot be empty")
    @ApiModelProperty(value = "密码", name = "password", example = "", dataType = "String", required = true)
    private String password;
}
