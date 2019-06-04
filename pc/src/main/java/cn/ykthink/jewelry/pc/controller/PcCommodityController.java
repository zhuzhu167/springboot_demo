package cn.ykthink.jewelry.pc.controller;

import cn.ykthink.jewelry.core.annotation.IgnoreToken;
import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.pc.commodity.bo.PcCommodityJewelryBO;
import cn.ykthink.jewelry.model.common.vo.CommonCommodityInfoVO;
import cn.ykthink.jewelry.model.common.vo.CommonCommodityListVO;
import cn.ykthink.jewelry.model.common.vo.CommonJewelryInfoVO;
import cn.ykthink.jewelry.model.common.vo.CommonJewelryListVO;
import cn.ykthink.jewelry.service.pc.PcCommodityService;
import com.github.catalpaflat.valid.annotation.ParameterValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @Resource
    PcCommodityService pcCommodityService;

    /**
     * get 商品列表
     */
    @IgnoreToken
    @GetMapping("commodityIntroduction")
    @ApiOperation(value = "商品列表", response = CommonCommodityListVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "categoryUuid", value = "类目uuid", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "第几页", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "显示多少条", required = false)
    })
    public ResponseEntity<Object> commodityIntroduction(
            @RequestParam(required = false) String categoryUuid,
            @ParameterValid(type = Integer.class, msg = "pageNum不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_index}") Integer pageNum,
            @ParameterValid(type = Integer.class, msg = "pageSize不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_size}") Integer pageSize) {
        return pcCommodityService.commodityList(categoryUuid,pageNum, pageSize);
    }

    /**
     * get 商品详情
     */
    @IgnoreToken
    @GetMapping("commodity/{commodityUuid}")
    @ApiOperation(value = "商品详情", response = CommonCommodityInfoVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "commodityUuid", value = "商品uuid", required = true),
    })
    public ResponseEntity<Object> commodity(@PathVariable String commodityUuid) {
        return pcCommodityService.commodity(commodityUuid);
    }

    /**
     * get 钻石列表
     */
    @IgnoreToken
    @GetMapping("jewelryIntroduction")
    @ApiOperation(value = "钻石列表", response = CommonJewelryListVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "第几页", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "显示多少条", required = false)
    })
    public ResponseEntity<Object> jewelryIntroduction(@ParameterValid(type = Integer.class, msg = "pageNum不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_index}") Integer pageNum,
                                                      @ParameterValid(type = Integer.class, msg = "pageSize不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_size}") Integer pageSize) {
        return pcCommodityService.jewelryList(pageNum, pageSize);
    }

    /**
     * get 钻石详情
     */
    @IgnoreToken
    @GetMapping("jewelry/{jewelryUuid}")
    @ApiOperation(value = "钻石详情", response = CommonJewelryInfoVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "jewelryUuid", value = "钻石uuid", required = true),
    })
    public ResponseEntity<Object> jewelryInfo(@PathVariable String jewelryUuid) {
        return pcCommodityService.jewelryInfo(jewelryUuid);
    }

    /**
     * post 加入购物车（商品和钻石需要捆绑买）
     */
    @PostMapping("commodityJewelry")
    @ApiOperation(value = "加入购物车", response = ResponseEntity.class)
    public ResponseEntity<Object> commodityJewelry(@RequestBody @Validated PcCommodityJewelryBO body) {
        return pcCommodityService.commodityJewelry(body);
    }
}
