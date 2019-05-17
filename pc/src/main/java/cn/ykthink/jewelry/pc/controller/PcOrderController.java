package cn.ykthink.jewelry.pc.controller;

import cn.ykthink.jewelry.core.annotation.ValidatePcPermission;
import cn.ykthink.jewelry.core.annotation.validateEnums.ValidatePcPermissionEnum;
import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserOrderVO;
import cn.ykthink.jewelry.service.pc.PcOrderService;
import com.github.catalpaflat.valid.annotation.ParameterValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * program: jewelry
 * description:用户订单Controller
 * author: mi
 * create: 2019-05-09 16:16
 **/
@RestController
@Api(description = SystemUri.PC_ROOT_URI_NAME + "订单")
@RequestMapping(SystemUri.PC_ROOT_URI + "order")
public class PcOrderController {
    @Autowired
    PcOrderService pcOrderService;

    @GetMapping("order")
    @ApiOperation(value = "订单", response = PcUserOrderVO.class)//补充订单砖石信息
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "第几页", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "显示多少条", required = false)
    })
    public ResponseEntity<Object> order(@ParameterValid(type = Integer.class, msg = "pageNum不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_index}") Integer pageNum,
                                         @ParameterValid(type = Integer.class, msg = "pageSize不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_size}") Integer pageSize) {
        return pcOrderService.order(pageNum,pageSize);
    }


}
