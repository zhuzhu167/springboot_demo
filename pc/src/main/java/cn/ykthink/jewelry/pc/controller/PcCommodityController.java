package cn.ykthink.jewelry.pc.controller;

import cn.ykthink.jewelry.core.annotation.ValidatePcPermission;
import cn.ykthink.jewelry.core.annotation.validateEnums.ValidatePcPermissionEnum;
import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.pc.commodity.vo.PcCommodityInfoVO;
import cn.ykthink.jewelry.model.pc.commodity.vo.PcCommodityIntroductionVO;
import cn.ykthink.jewelry.model.pc.commodity.vo.PcCommodityJewelryInfoVO;
import cn.ykthink.jewelry.model.pc.commodity.vo.PcCommodityJewelryIntroductionVO;
import cn.ykthink.jewelry.service.pc.PcCommodityService;
import com.github.catalpaflat.valid.annotation.ParameterValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "`商品列表", response = PcCommodityIntroductionVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "第几页", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "显示多少条", required = false)
    })
    public ResponseEntity<Object> category(@ParameterValid(type = Integer.class, msg = "pageNum不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_index}") Integer pageNum,
                                           @ParameterValid(type = Integer.class, msg = "pageSize不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_size}") Integer pageSize) {
        return pcCommodityService.commodityIntroduction(pageNum, pageSize);
    }

    /**
     * get 商品详情
     */
    @ValidatePcPermission(validatePcPermissionEnum = ValidatePcPermissionEnum.PC_USER)
    @GetMapping("commodity/{commodityUuid}")
    @ApiOperation(value = "商品详情", response = PcCommodityInfoVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "commodityUuid", value = "商品uuid", required = true),
    })
    public ResponseEntity<Object> commodity(@PathVariable String commodityUuid) {
        return pcCommodityService.commodity(commodityUuid);
    }

    /**
     * get 钻石列表
     */
    @GetMapping("jewelry")
    @ApiOperation(value = "钻石", response = PcCommodityJewelryIntroductionVO.class)
    public ResponseEntity<Object> jewelry() {
        return null;
    }

    /**
     * get 砖石详情
     */
    @GetMapping("jewelry/{jewelryUuid}")
    @ApiOperation(value = "钻石详情", response = PcCommodityJewelryInfoVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "jewelryUuid", value = "钻石uuid", required = true),
    })
    public ResponseEntity<Object> jewelry(@PathVariable String jewelryUuid) {
        return null;
    }

    /**
     * post 加入购物车（商品和砖石需要捆绑买）
     */

}
