package cn.ykthink.jewelry.model.common.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Author: YK
 * Title: PcUserInfoTO
 * Description: 用户信息PO
 * Date: 2019/4/28
 * Time: 15:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoPO extends BasePO {
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
}
