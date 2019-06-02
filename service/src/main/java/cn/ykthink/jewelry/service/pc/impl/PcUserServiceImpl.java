package cn.ykthink.jewelry.service.pc.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.support.redis.RedisSupport;
import cn.ykthink.jewelry.core.support.tx.TXSmsSupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.core.untils.Md5Utils;
import cn.ykthink.jewelry.model.comm.po.ConsigneePO;
import cn.ykthink.jewelry.model.comm.po.UserInfoPO;
import cn.ykthink.jewelry.model.pc.user.bo.*;
import cn.ykthink.jewelry.model.pc.user.to.PcUserInfoTO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserLoginVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserPersonInfoVO;
import cn.ykthink.jewelry.orm.pc.PcUserMapper;
import cn.ykthink.jewelry.service.pc.PcUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static cn.ykthink.jewelry.core.constant.TXSmsTemplateConstant.SMS_SIGN;
import static cn.ykthink.jewelry.core.constant.TXSmsTemplateConstant.WX_REGISTER;

/**
 * Author: YK
 * Title: PcUserServiceImpl
 * Description: 客户端用户ServiceImpl
 * Date: 2019/4/28
 * Time: 14:44
 */
@Service
public class PcUserServiceImpl implements PcUserService {
    @Resource
    PcUserMapper pcUserMapper;
    @Resource
    TXSmsSupport txSmsSupport;
    @Resource
    private RedisSupport redisSupport;

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
            String code = redisSupport.get(body.getPhone() + "_register_code");
            if (StringUtils.isBlank(code)) {
                return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "验证码已失效请重新获取", "The verification code has expired, please re-acquire");
            }
            if (!code.equals(body.getCode())) {
                return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "验证码错误", "Verification code error");
            }
            UserInfoPO userInfoPO = new UserInfoPO();
            userInfoPO.setAccount(body.getAccount());
            userInfoPO.setPassword(Md5Utils.getStringMD5(body.getPassword()));
            userInfoPO.setPhone(body.getPhone());
            if (pcUserMapper.insertAccount(userInfoPO) > 0) {
                return ResponseEntitySupport.success("注册成功", "Registered successfully");
            } else {
                return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "数据异常", "Abnormal data");
            }
        }
    }

    @Override
    public ResponseEntity<Object> registerCode(PcUserRegisterCodeBO body) {
        String phone = body.getPhone();
        Map<String, Object> request = new HashMap<>();
        request.put("phone", phone);
        PcUserInfoTO pcUserInfoTO = pcUserMapper.queryAccountPwd(request);
        if (pcUserInfoTO != null) {
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "手机号码已被注册", "the account is existed");
        }
        String code = redisSupport.get(phone + "_register_code_status");
        if (StringUtils.isNotBlank(code)) {
            return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, "已发送短信，请1分钟后再试", "SMS has been sent, please try again in 1 minute");
        }
        Random r = new Random();
        Integer registerCode = r.nextInt(9999);
        txSmsSupport.TXSendSms(WX_REGISTER, SMS_SIGN, phone, registerCode.toString(), "5");
        redisSupport.set(phone + "_register_code", registerCode.toString(), 60 * 5);
        redisSupport.set(phone + "_register_code_status", "1", 60);
        return ResponseEntitySupport.success();
    }

    @Override
    public ResponseEntity<Object> person() {
        String userUuid = JWTokenUtil.getJWTokenUuid();
        PcUserPersonInfoVO pcUserPersonInfoVO = pcUserMapper.selectPersonMessage(userUuid);
        return ResponseEntitySupport.success(pcUserPersonInfoVO);
    }

    @Override
    public ResponseEntity<Object> editPerson(PcUserEditPersonBO body) {
        String userUuid = JWTokenUtil.getJWTokenUuid();
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
        String userUuid = JWTokenUtil.getJWTokenUuid();
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
        String userUuid = JWTokenUtil.getJWTokenUuid();
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        pcUserMapper.selectConsigneeMessage(userUuid);
        JSONObject response = new JSONObject();
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
        String userUuid = JWTokenUtil.getJWTokenUuid();
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
