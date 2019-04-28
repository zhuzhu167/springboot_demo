package cn.ykthink.jewelry.service.pc;

import cn.ykthink.jewelry.model.pc.user.to.PcLoginTO;
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
     * @param pcLoginTO
     * @return
     */
    ResponseEntity<Object> login(PcLoginTO pcLoginTO);
}
