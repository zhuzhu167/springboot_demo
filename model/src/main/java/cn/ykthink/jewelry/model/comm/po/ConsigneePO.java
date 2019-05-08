package cn.ykthink.jewelry.model.comm.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * program: jewelry
 * description:收货人PO
 * author: mi
 * create: 2019-05-05 19:23
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class ConsigneePO extends BasePO {
    /**
     * 用户uuid
     */
    private String userUuid;
    /**
     * 收货人姓名
     */
    private String receiverName;
    /**
     * 收货人手机号码
     */
    private String receiverPhoneNumber;
    /**
     * 收货人所在省份
     */
    private String receiverProvince;
    /**
     * 收货人所在城市
     */
    private String receiverCity;
    /**
     * 收货人所在区/县
     */
    private String receiverDistrict;
    /**
     * 收货人详细地址
     */
    private String receiverAddress;
    /**
     * 邮编
     */
    private String zipCode;

}
