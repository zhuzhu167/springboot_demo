package cn.ykthink.jewelry.model.pc.user.to;

import cn.ykthink.jewelry.model.comm.po.BasePO;
import lombok.Data;

/**
 * Author: YK
 * Title: PcUserInfoTO
 * Description: 用户信息VO
 * Date: 2019/4/28
 * Time: 15:09
 */
@Data
public class PcUserInfoTO extends BasePO {
    /**
     * 用户uuid
     */
    private String uuid;
    /**
     * 密码
     */
    private String password;

}
