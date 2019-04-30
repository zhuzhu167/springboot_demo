package cn.ykthink.jewelry.service.pc;

import cn.ykthink.jewelry.model.pc.user.bo.PcLoginBO;
import cn.ykthink.jewelry.model.pc.user.bo.PcRegisterBO;
import org.springframework.http.ResponseEntity;

/**
 * Author: YK
 * Title: PcUserService
 * Description: 客户端用户Service
 * Date: 2019/4/28
 * Time: 14:43
 */
public interface PcUserService {

    /**
     * 用户登录
     *
     * @param pcLoginBO
     * @return
     */
    ResponseEntity<Object> login(PcLoginBO pcLoginBO);

    /**
     * 用户注册
     * @param pcRegisterBO
     * @return
     */
    ResponseEntity<Object> register(PcRegisterBO pcRegisterBO);

    /**
     * 获取个人信息
     * @return
     */
    ResponseEntity<Object> person();
}
