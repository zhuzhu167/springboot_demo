package cn.ykthink.jewelry.pc.controller;

import cn.ykthink.jewelry.core.annotation.ValidatePcPermission;
import cn.ykthink.jewelry.core.annotation.validateEnums.ValidatePcPermissionEnum;
import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.pc.user.bo.PcUserEditPerson;
import cn.ykthink.jewelry.model.pc.user.bo.PcUserEditPwd;
import cn.ykthink.jewelry.model.pc.user.bo.PcUserLoginBO;
import cn.ykthink.jewelry.model.pc.user.bo.PcUserRegisterBO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserLoginVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserPersonVO;
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
    public ResponseEntity<Object> login(@RequestBody @Validated PcUserLoginBO pcUserLoginBO) {
        return pcUserService.login(pcUserLoginBO);
    }

    @PostMapping("register")
    @ApiOperation(value = "客户端注册", response = ResponseEntity.class)
    public ResponseEntity<Object> register(@RequestBody @Validated PcUserRegisterBO body) {
        return pcUserService.register(body);
    }

    @ValidatePcPermission(validatePcPermissionEnum = ValidatePcPermissionEnum.PC_USER)
    @GetMapping("person")
    @ApiOperation(value = "个人信息", response = PcUserPersonVO.class)
    public ResponseEntity<Object> person() {
        return pcUserService.person();
    }

    @PutMapping("person")
    @ApiOperation(value = "修改资料", response = ResponseEntity.class)
    public ResponseEntity<Object> editPerson(@RequestBody PcUserEditPerson body) {
        return null;
    }

    @PutMapping("pwd")
    @ApiOperation(value = "修改密码", response = ResponseEntity.class)
    public ResponseEntity<Object> pwd(@RequestBody PcUserEditPwd body) {
        return null;
    }


}
