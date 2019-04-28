package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.core.untils.Md5Utils;
import cn.ykthink.jewelry.model.pc.user.to.PcLoginTO;
import cn.ykthink.jewelry.model.pc.user.to.UserInfoTO;
import cn.ykthink.jewelry.orm.pc.PcUserMapper;
import cn.ykthink.jewelry.service.pc.PcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Author: YK
 * Title: PcUserServiceImpl
 * Description: 客户端用户ServiceImpl
 * Date: 2019/4/28
 * Time: 14:44
 */
@Service
public class PcUserServiceImpl implements PcUserService {
    @Autowired
    PcUserMapper pcUserMapper;

    @Override
    public ResponseEntity<Object> login(PcLoginTO pcLoginTO) {
        UserInfoTO userInfoTO = pcUserMapper.queryAccountPwd(pcLoginTO.getAccount());
        if (userInfoTO != null && userInfoTO.getPassword().equals(Md5Utils.getStringMD5(pcLoginTO.getPassword()))) {
            String token = JWTokenUtil.generateToken(userInfoTO.getUuid());
            return ResponseEntitySupport.success(token);
        } else{
            return ResponseEntitySupport.error(HttpStatus.NOT_FOUND, "登录名或密码错误", "account or password is wrong");
        }
    }
}
