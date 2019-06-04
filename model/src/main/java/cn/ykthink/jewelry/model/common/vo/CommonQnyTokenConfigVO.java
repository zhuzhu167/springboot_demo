package cn.ykthink.jewelry.model.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: YK
 * Title: CommonQnyTokenConfigVO
 * Description: 七牛云token配置
 * Date: 2019/6/4
 * Time: 17:46
 */
@Data
public class CommonQnyTokenConfigVO {
    @ApiModelProperty(value = "认证token", name = "token", example = "", dataType = "String", required = true)
    private String token;
    @ApiModelProperty(value = "cdn域名", name = "cdnUrl", example = "", dataType = "String", required = true)
    private String cdnUrl;
}
