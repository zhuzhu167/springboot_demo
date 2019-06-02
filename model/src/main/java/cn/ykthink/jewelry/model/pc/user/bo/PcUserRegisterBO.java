package cn.ykthink.jewelry.model.pc.user.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Author: YK
 * Title: PcUserRegisterBO
 * Description: 客户端注册TO
 * Date: 2019/4/28
 * Time: 17:10
 */
@Data
public class PcUserRegisterBO {
    @NotBlank(message = "账号不能为空")
    @ApiModelProperty(value = "账号", name = "account", example = "test1", dataType = "String", required = true)
    private String account;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", name = "password", example = "", dataType = "String", required = true)
    private String password;

    @NotBlank(message = "手机号码不能为空")
    @ApiModelProperty(value = "手机号码", name = "phone", example = "", dataType = "String", required = true)
    private String phone;

    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码", name = "code", example = "", dataType = "String", required = true)
    private String code;
}
