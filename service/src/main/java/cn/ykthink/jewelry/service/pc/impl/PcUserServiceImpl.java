package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.core.untils.Md5Utils;
import cn.ykthink.jewelry.model.comm.po.ConsigneePO;
import cn.ykthink.jewelry.model.comm.po.UserInfoPO;
import cn.ykthink.jewelry.model.pc.user.bo.*;
import cn.ykthink.jewelry.model.pc.user.to.PcUserInfoTO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserLoginVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserPersonInfoVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserReceiverInfoVO;
import cn.ykthink.jewelry.orm.pc.PcUserMapper;
import cn.ykthink.jewelry.service.pc.PcUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Object> request = new HashMap<>();
        request.put("account", body.getAccount());
        PcUserInfoTO pcUserInfoTO = pcUserMapper.queryAccountPwd(request);
        if (pcUserInfoTO != null && pcUserInfoTO.getPassword().equals(Md5Utils.getStringMD5(body.getPassword()))) {
            PcUserLoginVO pcUserLoginVO = new PcUserLoginVO();
            Map<String, Object> map = new HashMap<>();
            map.put("uuid", pcUserInfoTO.getUuid());
            String accessToken = JWTokenUtil.generateJWToken(map, (24 * 60 * 60 * 1000L));//24小时
            pcUserLoginVO.setToken(accessToken);
            return ResponseEntitySupport.success(pcUserLoginVO);
        } else {
            return ResponseEntitySupport.error(HttpStatus.NOT_FOUND, "登录名或密码错误", "account or password is wrong");
        }
    }

    @Override
    public ResponseEntity<Object> register(PcUserRegisterBO body) {
        Map<String, Object> request = new HashMap<>();
        request.put("account", body.getAccount());
        PcUserInfoTO pcUserInfoTO = pcUserMapper.queryAccountPwd(request);
        if (pcUserInfoTO != null) {
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "该账号已被注册", "the account is existed");
        } else {
            UserInfoPO userInfoPO = new UserInfoPO();
            userInfoPO.setAccount(body.getAccount());
            userInfoPO.setPassword(Md5Utils.getStringMD5(body.getPassword()));
            if (pcUserMapper.insertAccount(userInfoPO) > 0) {
                return ResponseEntitySupport.success("注册成功", "Registered successfully");
            } else {
                return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "数据异常", "Abnormal data");
            }
        }
    }

    @Override
    public ResponseEntity<Object> person() {
        String userUuid = JWTokenUtil.validateJWToken(JWTokenUtil.getRequestHeader("X-Access-Token"), "uuid");
        PcUserPersonInfoVO pcUserPersonInfoVO = pcUserMapper.selectPersonMessage(userUuid);
        return ResponseEntitySupport.success(pcUserPersonInfoVO);
    }

    @Override
    public ResponseEntity<Object> editPerson(PcUserEditPersonBO body) {
        String userUuid = JWTokenUtil.validateJWToken(JWTokenUtil.getRequestHeader("X-Access-Token"), "uuid");
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setEmail(body.getEmail());
        userInfoPO.setPhone(body.getPhone());
        userInfoPO.setUsername(body.getName());
        userInfoPO.setUuid(userUuid);
        if (pcUserMapper.updatePersonMessage(userInfoPO) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "数据异常", "Abnormal data");
        }
    }

    @Override
    public ResponseEntity<Object> editPwd(PcUserEditPwdBO body) {
        String userUuid = JWTokenUtil.validateJWToken(JWTokenUtil.getRequestHeader("X-Access-Token"), "uuid");
        Map<String, Object> request = new HashMap<>();
        request.put("uuid", userUuid);
        PcUserInfoTO pcUserInfoTO = pcUserMapper.queryAccountPwd(request);
        if (!Md5Utils.getStringMD5(body.getOldPwd()).equals(pcUserInfoTO.getPassword())) {
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "旧密码错误", "Old password error");
        }
        UserInfoPO userInfoPO = new UserInfoPO();
        userInfoPO.setUuid(userUuid);
        userInfoPO.setPassword(Md5Utils.getStringMD5(body.getNewPwd()));
        if (pcUserMapper.updateUserPwd(userInfoPO) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "数据异常", "Abnormal data");
        }
    }

    @Override
    public ResponseEntity<Object> consignee(Integer pageNum, Integer pageSize) {
        String userUuid = JWTokenUtil.validateJWToken(JWTokenUtil.getRequestHeader("X-Access-Token"), "uuid");
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        JSONObject response = new JSONObject();
        pcUserMapper.selectConsigneeMessage(userUuid);
        response.put("total", page.getTotal());
        response.put("response", page.getResult());
        return ResponseEntitySupport.success(response);
    }

    @Override
    public ResponseEntity<Object> removeConsignee(String consigneeUuid) {
        if (pcUserMapper.removeIsDeleted("consignee", consigneeUuid) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "数据异常", "Abnormal data");
        }
    }

    @Override
    public ResponseEntity<Object> editConsignee(String consigneeUuid, PcUerReceiverInfoBO body) {
        ConsigneePO consigneePO = new ConsigneePO();
        consigneePO.setReceiverPhoneNumber(body.getPhone());
        consigneePO.setZipCode(body.getZipCode());
        consigneePO.setReceiverName(body.getName());
        consigneePO.setReceiverProvince(body.getProvince());
        consigneePO.setReceiverDistrict(body.getDistrict());
        consigneePO.setReceiverAddress(body.getAddress());
        consigneePO.setReceiverCity(body.getCity());
        consigneePO.setUuid(consigneeUuid);
        if (pcUserMapper.updateConsignee(consigneePO) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "数据异常", "Abnormal data");
        }
    }

    @Override
    public ResponseEntity<Object> insertConsignee(PcUserInsertConsigneeBO body) {
        String userUuid = JWTokenUtil.validateJWToken(JWTokenUtil.getRequestHeader("X-Access-Token"), "uuid");
        ConsigneePO consigneePO = new ConsigneePO();
        consigneePO.setReceiverAddress(body.getAddress());
        consigneePO.setReceiverCity(body.getCity());
        consigneePO.setReceiverDistrict(body.getDistrict());
        consigneePO.setReceiverProvince(body.getProvince());
        consigneePO.setReceiverName(body.getName());
        consigneePO.setZipCode(body.getZipCode());
        consigneePO.setReceiverPhoneNumber(body.getPhone());
        consigneePO.setUserUuid(userUuid);
        if (pcUserMapper.insertConsignee(consigneePO) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "数据异常", "Abnormal data");
        }
    }

}
