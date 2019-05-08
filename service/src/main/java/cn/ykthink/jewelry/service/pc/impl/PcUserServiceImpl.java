package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.core.untils.Md5Utils;
import cn.ykthink.jewelry.model.comm.po.UserInfoPO;
import cn.ykthink.jewelry.model.pc.user.bo.PcUserLoginBO;
import cn.ykthink.jewelry.model.pc.user.bo.PcUserRegisterBO;
import cn.ykthink.jewelry.model.pc.user.to.PcUserInfoTO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserLoginVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserPersonInfoVO;
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
    public ResponseEntity<Object> login(PcUserLoginBO body) {
        PcUserInfoTO pcUserInfoTO = pcUserMapper.queryAccountPwd(body.getAccount());
        if (pcUserInfoTO != null && pcUserInfoTO.getPassword().equals(Md5Utils.getStringMD5(body.getPassword()))) {
            PcUserLoginVO pcUserLoginVO=new PcUserLoginVO();
            pcUserLoginVO.setToken(JWTokenUtil.generateToken(pcUserInfoTO.getUuid()));
            return ResponseEntitySupport.success(pcUserLoginVO);
        } else{
            return ResponseEntitySupport.error(HttpStatus.NOT_FOUND, "登录名或密码错误", "account or password is wrong");
        }
    }

    @Override
    public ResponseEntity<Object> register(PcUserRegisterBO body) {
        PcUserInfoTO pcUserInfoTO = pcUserMapper.queryAccountPwd(body.getAccount());
        if(pcUserInfoTO!=null){
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "该账号已被注册", "the account is existed");
        }else{
            UserInfoPO userInfoPO=new UserInfoPO();
            userInfoPO.setAccount(body.getAccount());
            userInfoPO.setPassword(Md5Utils.getStringMD5(body.getPassword()));
            if(pcUserMapper.insertAccount(userInfoPO)>0){
                return ResponseEntitySupport.success("注册成功","Registered successfully");
            }else{
                return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "数据异常", "Abnormal data");
            }
        }
    }

    @Override
    public ResponseEntity<Object> person() {
        PcUserPersonInfoVO PersonMessage=pcUserMapper.selectPersonMessage("");
        return null;
    }
}
