package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * program: jewelry
 * description:订单信息VO
 * author: mi
 * create: 2019-05-13 18:55
 **/
@Data
public class PcUserOrderInfoVO {
    @ApiModelProperty(value = "订单list", name = "orderList", dataType = "List", required = true)
    private List<PcUserOrderVO> orderList;
}
