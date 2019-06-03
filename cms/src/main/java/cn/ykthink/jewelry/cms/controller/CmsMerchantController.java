package cn.ykthink.jewelry.cms.controller;

import cn.ykthink.jewelry.core.annotation.IgnoreToken;
import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.cms.merchant.bo.CmsMerchantLoginBO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserLoginVO;
import cn.ykthink.jewelry.service.cms.impl.CmsMerchantServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author: YK
 * Title: CmsUserController
 * Description: 用户控制器
 * Date: 2019/6/3
 * Time: 23:01
 */
@RestController
@Api(description = SystemUri.CMS_ROOT_URI_NAME + "商家")
@RequestMapping(SystemUri.CMS_ROOT_URI + "merchant")
public class CmsMerchantController {
    @Resource
    CmsMerchantServiceImpl cmsMerchantService;

    @PostMapping("login")
    @IgnoreToken
    @ApiOperation(value = "商家端登录", response = PcUserLoginVO.class)
    public ResponseEntity<Object> login(@RequestBody @Validated CmsMerchantLoginBO body) {
        return cmsMerchantService.login(body);
    }
}
