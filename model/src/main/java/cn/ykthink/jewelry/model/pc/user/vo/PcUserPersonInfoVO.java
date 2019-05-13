package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: YK
 * Title: PcUserPersonInfoVO
 * Description: 用户个人信息VO
 * Date: 2019/4/29
 * Time: 11:22
 */
@Data
public class PcUserPersonInfoVO {
    @ApiModelProperty(value = "用户名称", name = "username", example = "username", dataType = "String", required = true)
    private String username;

    @ApiModelProperty(value = "手机号", name = "phone", example = "13712000001", dataType = "String", required = true)
    private String phone;

    @ApiModelProperty(value = "邮箱", name = "email", example = "123@yeah.net", dataType = "String", required = true)
    private String email;
}
