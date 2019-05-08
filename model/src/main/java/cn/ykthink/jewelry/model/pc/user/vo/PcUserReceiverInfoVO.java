package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: YK
 * Title: PcUserReceiverInfoVO
 * Description: 收货人信息
 * Date: 2019/5/8
 * Time: 14:16
 */
@Data
public class PcUserReceiverInfoVO {
    @ApiModelProperty(value = "收货人姓名", name = "name", example = "name", dataType = "String", required = true)
    private String name;
    @ApiModelProperty(value = "收货人地址", name = "address", example = "address", dataType = "String", required = true)
    private String address;
    @ApiModelProperty(value = "收货人电话", name = "phone", example = "13711111110", dataType = "String", required = true)
    private String phone;
    @ApiModelProperty(value = "邮编", name = "zipCode", example = "52222", dataType = "String", required = true)
    private String zipCode;
}
