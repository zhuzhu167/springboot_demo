package cn.ykthink.jewelry.model.pc.cart.to;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: YK
 * Title: PcCartReceiverInfoTO
 * Description: 收货人信息TO
 * Date: 2019/6/2
 * Time: 14:36
 */
@Data
public class PcCartReceiverInfoTO {
    @ApiModelProperty(value = "收货信息uuid", name = "receiverUuid", example = "name", dataType = "String", required = true)
    private String receiverUuid;

    @ApiModelProperty(value = "收货人姓名", name = "name", example = "name", dataType = "String", required = true)
    private String name;

    @ApiModelProperty(value = "省份", name = "province", example = "address", dataType = "String", required = true)
    private String province;

    @ApiModelProperty(value = "城市", name = "city", example = "address", dataType = "String", required = true)
    private String city;

    @ApiModelProperty(value = "县", name = "district", example = "address", dataType = "String", required = true)
    private String district;

    @ApiModelProperty(value = "详细地址", name = "address", example = "address", dataType = "String", required = true)
    private String address;

    @ApiModelProperty(value = "收货人电话", name = "phone", example = "13711111110", dataType = "String", required = true)
    private String phone;

    @ApiModelProperty(value = "邮编", name = "zipCode", example = "52222", dataType = "String", required = true)
    private String zipCode;
}
