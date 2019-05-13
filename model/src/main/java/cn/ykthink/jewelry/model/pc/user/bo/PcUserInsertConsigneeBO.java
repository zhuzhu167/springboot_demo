package cn.ykthink.jewelry.model.pc.user.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Author: YK
 * Title: PcUserInsertConsigneeBO
 * Description: 新增收货人信息
 * Date: 2019/5/13
 * Time: 8:58
 */
@Data
public class PcUserInsertConsigneeBO {
    @ApiModelProperty(value = "收货人名称", name = "name", example = "", dataType = "String", required = false)
    private String name;
    @ApiModelProperty(value = "收货人手机", name = "phone", example = "", dataType = "String", required = false)
    private String phone;
    @ApiModelProperty(value = "收货人县区", name = "district", example = "", dataType = "String", required = false)
    private String district;
    @ApiModelProperty(value = "收货人城市", name = "city", example = "", dataType = "String", required = false)
    private String city;
    @ApiModelProperty(value = "收货人省份", name = "province", example = "", dataType = "String", required = false)
    private String province;
    @ApiModelProperty(value = "收货人详细地址", name = "address", example = "", dataType = "String", required = false)
    private String address;
    @ApiModelProperty(value = "收货人邮编", name = "zipCode", example = "", dataType = "String", required = false)
    private String zipCode;
}
