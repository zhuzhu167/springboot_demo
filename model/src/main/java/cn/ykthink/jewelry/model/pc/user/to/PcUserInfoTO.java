package cn.ykthink.jewelry.model.pc.user.to;

import lombok.Data;

/**
 * Author: YK
 * Title: PcUserInfoTO
 * Description: 用户信息VO
 * Date: 2019/4/28
 * Time: 15:09
 */
@Data
public class PcUserInfoTO {
    /**
     * 用户uuid
     */
    private String uuid;
    /**
     * 密码
     */
    private String password;

}
