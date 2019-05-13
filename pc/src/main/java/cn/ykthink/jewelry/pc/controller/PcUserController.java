package cn.ykthink.jewelry.pc.controller;

import cn.ykthink.jewelry.core.annotation.ValidatePcPermission;
import cn.ykthink.jewelry.core.annotation.validateEnums.ValidatePcPermissionEnum;
import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.pc.user.bo.*;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserLoginVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserPersonInfoVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserReceiverInfoVO;
import cn.ykthink.jewelry.service.pc.PcUserService;
import com.github.catalpaflat.valid.annotation.ParameterValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    @ApiOperation(value = "个人信息", response = PcUserPersonInfoVO.class)
    public ResponseEntity<Object> person() {
        return pcUserService.person();
    }

    @ValidatePcPermission(validatePcPermissionEnum = ValidatePcPermissionEnum.PC_USER)
    @PutMapping("person")
    @ApiOperation(value = "修改资料", response = ResponseEntity.class)
    public ResponseEntity<Object> editPerson(@RequestBody PcUserEditPersonBO body) {
        return pcUserService.editPerson(body);
    }

    @ValidatePcPermission(validatePcPermissionEnum = ValidatePcPermissionEnum.PC_USER)
    @PutMapping("pwd")
    @ApiOperation(value = "修改密码", response = ResponseEntity.class)
    public ResponseEntity<Object> editPwd(@RequestBody PcUserEditPwdBO body) {
        return pcUserService.editPwd(body);
    }

    @ValidatePcPermission(validatePcPermissionEnum = ValidatePcPermissionEnum.PC_USER)
    @PostMapping("consignee")
    @ApiOperation(value = "新增收货信息", response = ResponseEntity.class)
    public ResponseEntity<Object> insertConsignee(@RequestBody PcUserInsertConsigneeBO body) {
        return pcUserService.insertConsignee(body);
    }


    @ValidatePcPermission(validatePcPermissionEnum = ValidatePcPermissionEnum.PC_USER)
    @GetMapping("consignee")
    @ApiOperation(value = "收货信息", response = PcUserReceiverInfoVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "第几页", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "显示多少条", required = false)
    })
    public ResponseEntity<Object> consignee(@ParameterValid(type = Integer.class, msg = "pageNum不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_index}") Integer pageNum,
                                            @ParameterValid(type = Integer.class, msg = "pageSize不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_size}") Integer pageSize) {
        return pcUserService.consignee(pageNum,pageSize);
    }

    @ValidatePcPermission(validatePcPermissionEnum = ValidatePcPermissionEnum.PC_USER)
    @DeleteMapping("consignee/{consigneeUuid}")
    @ApiOperation(value = "删除收货信息", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "consigneeUuid", value = "收货信息uuid", required = true),
    })
    public ResponseEntity<Object> removeConsignee(@PathVariable String consigneeUuid) {
        return pcUserService.removeConsignee(consigneeUuid);
    }

    @ValidatePcPermission(validatePcPermissionEnum = ValidatePcPermissionEnum.PC_USER)
    @PutMapping("consignee/{consigneeUuid}")
    @ApiOperation(value = "修改收货信息", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "consigneeUuid", value = "收货信息uuid", required = true),
    })
    public ResponseEntity<Object> editConsignee(@PathVariable String consigneeUuid, @RequestBody PcUerReceiverInfoBO body) {
        return pcUserService.editConsignee(consigneeUuid,body);
    }
}
