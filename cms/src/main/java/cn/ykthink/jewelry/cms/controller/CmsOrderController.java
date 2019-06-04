package cn.ykthink.jewelry.cms.controller;

import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.pc.order.vo.PcUserOrderVO;
import cn.ykthink.jewelry.service.cms.CmsOrderService;
import cn.ykthink.jewelry.service.common.CommonOrderService;
import com.github.catalpaflat.valid.annotation.ParameterValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author: YK
 * Title: CmsOrderController
 * Description: 订单控制器
 * Date: 2019/6/3
 * Time: 23:32
 */
@RestController
@Api(description = SystemUri.CMS_ROOT_URI_NAME + "订单")
@RequestMapping(SystemUri.CMS_ROOT_URI + "order")
public class CmsOrderController {
    @Resource
    CmsOrderService cmsOrderService;

    @GetMapping("order")
    @ApiOperation(value = "订单", response = PcUserOrderVO.class)//补充订单砖石信息
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "orderNo", value = "订单号", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "第几页", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "显示多少条", required = false)
    })
    public ResponseEntity<Object> order(
            @RequestParam(required = false) String orderNo,
            @ParameterValid(type = Integer.class, msg = "pageNum不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_index}") Integer pageNum,
            @ParameterValid(type = Integer.class, msg = "pageSize不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_size}") Integer pageSize) {
        return cmsOrderService.order(orderNo,pageNum, pageSize);
    }

}
