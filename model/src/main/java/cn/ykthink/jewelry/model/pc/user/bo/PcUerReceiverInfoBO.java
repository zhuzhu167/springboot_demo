package cn.ykthink.jewelry.model.pc.user.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Author: YK
 * Title: PcUerReceiverInfoBO
 * Description: 收货信息BO
 * Date: 2019/5/8
 * Time: 15:45
 */
@Data
public class PcUerReceiverInfoBO {
    @NotBlank(message = "收货信息uuid不能为空")
    @ApiModelProperty(value = "收货信息uuid", name = "receiverUuid", example = "name", dataType = "String", required = true)
    private String receiverUuid;

    @NotBlank(message = "收货人姓名不能为空")
    @ApiModelProperty(value = "收货人姓名", name = "name", example = "name", dataType = "String", required = true)
    private String name;

    @NotBlank(message = "收货人姓名不能为空")
    @ApiModelProperty(value = "省份", name = "province", example = "address", dataType = "String", required = true)
    private String province;

    @NotBlank(message = "城市不能为空")
    @ApiModelProperty(value = "城市", name = "city", example = "address", dataType = "String", required = true)
    private String city;

    @NotBlank(message = "县不能为空")
    @ApiModelProperty(value = "县", name = "district", example = "address", dataType = "String", required = true)
    private String district;

    @NotBlank(message = "详细地址不能为空")
    @ApiModelProperty(value = "详细地址", name = "address", example = "address", dataType = "String", required = true)
    private String address;

    @NotBlank(message = "收货人电话不能为空")
    @ApiModelProperty(value = "收货人电话", name = "phone", example = "13711111110", dataType = "String", required = true)
    private String phone;

    @NotBlank(message = "邮编不能为空")
    @ApiModelProperty(value = "邮编", name = "zipCode", example = "52222", dataType = "String", required = true)
    private String zipCode;
}
