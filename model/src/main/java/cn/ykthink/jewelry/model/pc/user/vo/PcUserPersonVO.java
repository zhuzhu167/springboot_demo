package cn.ykthink.jewelry.model.pc.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Author: YK
 * Title: PcUserPersonVO
 * Description: 个人信息VO
 * Date: 2019/5/8
 * Time: 14:17
 */
@Data
public class PcUserPersonVO {
    @ApiModelProperty(value = "用户信息", name = "personInfo", example = "", dataType = "PcUserPersonInfoVO", required = true)
    private PcUserPersonInfoVO personInfo;
    @ApiModelProperty(value = "收货地址", name = "receiverInfo", example = "", dataType = "PcUserReceiverInfoVO", required = true)
    private List<PcUserReceiverInfoVO> receiverInfo;
}
