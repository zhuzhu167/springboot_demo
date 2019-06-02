package cn.ykthink.jewelry.model.pc.user.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Author: YK
 * Title: PcUserRegisterCodeBO
 * Description: 注册验证码BO
 * Date: 2019/6/2
 * Time: 23:16
 */
@Data
public class PcUserRegisterCodeBO {
    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号", name = "phone", example = "13712000000", dataType = "String", required = true)
    private String phone;
}
