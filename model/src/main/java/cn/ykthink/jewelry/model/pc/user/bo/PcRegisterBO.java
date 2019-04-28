package cn.ykthink.jewelry.model.pc.user.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Author: YK
 * Title: PcRegisterBO
 * Description: 客户端注册TO
 * Date: 2019/4/28
 * Time: 17:10
 */
@Data
public class PcRegisterBO {
    @NotBlank(message = "账号不能为空")
    @ApiModelProperty(value = "账号", name = "account", example = "test1", dataType = "String", required = true)
    private String account;
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", name = "password", example = "", dataType = "String", required = true)
    private String password;
}
