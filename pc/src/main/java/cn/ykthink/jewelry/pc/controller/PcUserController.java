package cn.ykthink.jewelry.pc.controller;

import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.pc.user.to.PcLoginTO;
import cn.ykthink.jewelry.service.pc.PcUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation(value = "用户端登录", response = ResponseEntity.class)
    public ResponseEntity<Object> login(@RequestBody @Validated PcLoginTO pcLoginTO) {
        return pcUserService.login(pcLoginTO);
    }
}
