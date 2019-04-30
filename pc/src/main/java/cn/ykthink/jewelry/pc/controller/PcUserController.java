package cn.ykthink.jewelry.pc.controller;

import cn.ykthink.jewelry.core.annotation.ValidatePcPermission;
import cn.ykthink.jewelry.core.annotation.validateEnums.ValidatePcPermissionEnum;
import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.pc.user.bo.PcLoginBO;
import cn.ykthink.jewelry.model.pc.user.bo.PcRegisterBO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserLoginVO;
import cn.ykthink.jewelry.service.pc.PcUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Author: YK
 * Title: PcUserController
 * Description: 用户控制器
 * Date: 2019/4/28
 * Time: 14:37
 */
@RestController
@Api(description = SystemUri.PC_ROOT_URI_NAME + "用户")
@RequestMapping(SystemUri.PC_ROOT_URI + "user")
public class PcUserController {
    @Autowired
    PcUserService pcUserService;

    @PostMapping("login")
    @ApiOperation(value = "用户端登录", response = PcUserLoginVO.class)
    public ResponseEntity<Object> login(@RequestBody @Validated PcLoginBO pcLoginBO) {
        return pcUserService.login(pcLoginBO);
    }

    @PostMapping("register")
    @ApiOperation(value = "客户端注册", response = ResponseEntity.class)
    public ResponseEntity<Object> register(@RequestBody @Validated PcRegisterBO pcRegisterBO) {
        return pcUserService.register(pcRegisterBO);
    }

//    @GetMapping("person")
//    @ApiOperation(value = "个人信息",response = ResponseEntity.class)
//    public ResponseEntity<Object> person(){
//        return pcUserService.person();
//    }
}
