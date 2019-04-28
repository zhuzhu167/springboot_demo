package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: YK
 * Title: PcUserLoginVO
 * Description: 客户端用户登录VO
 * Date: 2019/4/28
 * Time: 16:59
 */
@Data
public class PcUserLoginVO {
    @ApiModelProperty(value = "下发的签名", name = "token", example = "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NjAwNDIxMDMsInV1aWQiOiI0MDI4NzI4MTY5ZDQzOTM1MDE2OWQ0Mzk1ZDVmMDAwMCJ9.bnrF5EpsaAXuKExsX5xDS-F4SGa95OuYdtJ1Iw_JzbrrVkRaLXHyu8KJY77VBUPp6BwPuuAH8IVpeq6SZxv4_g", dataType = "String", required = true)
    private String token;
}
