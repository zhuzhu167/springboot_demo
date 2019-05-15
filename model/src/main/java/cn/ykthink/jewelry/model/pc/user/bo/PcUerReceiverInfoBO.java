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
    @NotBlank
    @ApiModelProperty(value = "收货信息uuid", name = "receiverUuid", example = "name", dataType = "String", required = true)
    private String receiverUuid;
    @NotBlank
    @ApiModelProperty(value = "收货人姓名", name = "name", example = "name", dataType = "String", required = true)
    private String name;
    @NotBlank
    @ApiModelProperty(value = "省份", name = "province", example = "address", dataType = "String", required = true)
    private String province;
    @NotBlank
    @ApiModelProperty(value = "城市", name = "city", example = "address", dataType = "String", required = true)
    private String city;
    @NotBlank
    @ApiModelProperty(value = "县", name = "district", example = "address", dataType = "String", required = true)
    private String district;
    @NotBlank
    @ApiModelProperty(value = "详细地址", name = "address", example = "address", dataType = "String", required = true)
    private String address;
    @NotBlank
    @ApiModelProperty(value = "收货人电话", name = "phone", example = "13711111110", dataType = "String", required = true)
    private String phone;
    @NotBlank
    @ApiModelProperty(value = "邮编", name = "zipCode", example = "52222", dataType = "String", required = true)
    private String zipCode;
}
