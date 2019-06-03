package cn.ykthink.jewelry.cms.controller;

import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.cms.commodity.vo.CmsCommodityListVO;
import cn.ykthink.jewelry.model.common.vo.CommonCommodityInfoVO;
import cn.ykthink.jewelry.service.cms.CmsCommodityService;
import cn.ykthink.jewelry.service.common.CommonCommodityService;
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
 * Title: CmsCommodityController
 * Description: 商品控制器
 * Date: 2019/6/3
 * Time: 23:32
 */
@RestController
@Api(description = SystemUri.CMS_ROOT_URI_NAME + "商品")
@RequestMapping(SystemUri.CMS_ROOT_URI + "commodity")
public class CmsCommodityController {
    @Resource
    CmsCommodityService cmsCommodityService;
    @Resource
    CommonCommodityService commonCommodityService;

    @GetMapping("commodityList")
    @ApiOperation(value = "商品列表", response = CmsCommodityListVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "categoryUuid", value = "类目uuid", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "第几页", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "显示多少条", required = false)
    })
    public ResponseEntity<Object> commodityList(
            @RequestParam String categoryUuid,
            @ParameterValid(type = Integer.class, msg = "pageNum不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_index}") Integer pageNum,
            @ParameterValid(type = Integer.class, msg = "pageSize不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_size}") Integer pageSize) {
        return commonCommodityService.commodityList(categoryUuid, pageNum, pageSize);
    }

    @GetMapping("commodity/{commodityUuid}")
    @ApiOperation(value = "商品详情", response = CommonCommodityInfoVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "commodityUuid", value = "商品uuid", required = true),
    })
    public ResponseEntity<Object> commodity(@PathVariable String commodityUuid) {
        return null;
    }

}
