package cn.ykthink.jewelry.pc.controller;

import cn.ykthink.jewelry.core.annotation.ValidatePcPermission;
import cn.ykthink.jewelry.core.annotation.validateEnums.ValidatePcPermissionEnum;
import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserCommodityInfoVO;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserCommodityIntroductionVO;
import cn.ykthink.jewelry.service.pc.PcCommodityService;
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
 * Title: PcCommodityController
 * Description: 商品信息Controller
 * Date: 2019/5/13
 * Time: 10:56
 */
@Api(description = SystemUri.PC_ROOT_URI_NAME + "商品")
@RequestMapping(SystemUri.PC_ROOT_URI + "commodity")
@RestController
public class PcCommodityController {
    /**
     * get 商品列表
     */
    @Resource
    PcCommodityService pcCommodityService;

    @ValidatePcPermission(validatePcPermissionEnum = ValidatePcPermissionEnum.PC_USER)
    @GetMapping("commodityIntroduction")
    @ApiOperation(value = "`商品列表", response = PcUserCommodityIntroductionVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "第几页", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "显示多少条", required = false)
    })
    public ResponseEntity<Object> category(@ParameterValid(type = Integer.class, msg = "pageNum不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_index}") Integer pageNum,
                                           @ParameterValid(type = Integer.class, msg = "pageSize不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_size}") Integer pageSize) {
        return pcCommodityService.commodityIntroduction(pageNum,pageSize);
    }
    /**
     * get 商品详情
     */
    @ValidatePcPermission(validatePcPermissionEnum = ValidatePcPermissionEnum.PC_USER)
    @GetMapping("commodity")
    @ApiOperation(value = "商品详情", response = PcUserCommodityInfoVO.class)
    public ResponseEntity<Object> commodity(String commodityUuid) {
        return pcCommodityService.commodity(commodityUuid);
    }
    /**
     *
     * get 砖石列表
     */

    /**
     * get 砖石详情
     */

    /**
     * post 加入购物车（商品和砖石需要捆绑买）
     */

}
