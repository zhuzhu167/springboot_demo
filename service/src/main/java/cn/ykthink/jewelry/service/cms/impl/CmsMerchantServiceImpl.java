package cn.ykthink.jewelry.service.cms.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import cn.ykthink.jewelry.core.untils.Md5Utils;
import cn.ykthink.jewelry.model.cms.merchant.bo.CmsMerchantLoginBO;
import cn.ykthink.jewelry.model.cms.merchant.to.CmsMerchantInfoTO;
import cn.ykthink.jewelry.model.cms.merchant.vo.CmsMerchantLoginVO;
import cn.ykthink.jewelry.orm.cms.CmsMerchantMapper;
import cn.ykthink.jewelry.service.cms.CmsMerchantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: YK
 * Title: CmsMerchantServiceImpl
 * Description: 商家service实现类
 * Date: 2019/6/3
 * Time: 23:04
 */
@Service
public class CmsMerchantServiceImpl implements CmsMerchantService {
    @Resource
    CmsMerchantMapper cmsMerchantMapper;


    @Override
    public ResponseEntity<Object> login(CmsMerchantLoginBO body) {
        if (!body.getAccount().equals("admin")) {
            return ResponseEntitySupport.error(HttpStatus.UNAUTHORIZED, "登录名或密码错误", "account or password is wrong");
        }
        Map<String, Object> request = new HashMap<>();
        request.put("account", body.getAccount());
        CmsMerchantInfoTO cmsMerchantInfoTO = cmsMerchantMapper.queryAccountPwd(request);

        if (cmsMerchantInfoTO != null && cmsMerchantInfoTO.getPassword().equals(Md5Utils.getStringMD5(body.getPassword()))) {
            CmsMerchantLoginVO cmsMerchantLoginVO = new CmsMerchantLoginVO();
            Map<String, Object> map = new HashMap<>();
            map.put("uuid", cmsMerchantInfoTO.getUuid());
            map.put("identity", "admin");
            String accessToken = JWTokenUtil.generateJWToken(map, (24 * 60 * 60 * 1000L));//24小时
            cmsMerchantLoginVO.setToken(accessToken);
            return ResponseEntitySupport.success(cmsMerchantLoginVO);
        } else {
            return ResponseEntitySupport.error(HttpStatus.UNAUTHORIZED, "登录名或密码错误", "account or password is wrong");
        }
    }
}
