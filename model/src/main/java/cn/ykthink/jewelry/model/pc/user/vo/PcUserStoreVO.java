package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * program: jewelry
 * description:库存VO
 * author: mi
 * create: 2019-05-15 20:40
 **/
@Data
public class PcUserStoreVO {

    @ApiModelProperty(value = "历史库存总量", name = "storeTotal", example = "1000", dataType = "Integer", required = true)
    private String storeTotal;

    @ApiModelProperty(value = "库存剩余量", name = "storeConsumption", example = "10", dataType = "Integer", required = true)
    private String storeConsumption;
}
