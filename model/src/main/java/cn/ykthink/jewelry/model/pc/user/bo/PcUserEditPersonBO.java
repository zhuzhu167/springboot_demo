package cn.ykthink.jewelry.model.pc.user.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: YK
 * Title: PcUserEditPerson
 * Description: 修改资料
 * Date: 2019/5/8
 * Time: 15:03
 */
@Data
public class PcUserEditPersonBO {
    @ApiModelProperty(value = "名称", name = "name", example = "", dataType = "String", required = false)
    private String name;

    @ApiModelProperty(value = "手机", name = "phone", example = "", dataType = "String", required = false)
    private String phone;

    @ApiModelProperty(value = "邮箱", name = "email", example = "", dataType = "String", required = false)
    private String email;
}
