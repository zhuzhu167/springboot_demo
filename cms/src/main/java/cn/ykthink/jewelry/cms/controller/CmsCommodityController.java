package cn.ykthink.jewelry.cms.controller;

import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.cms.commodity.bo.CmsCommodityBO;
import cn.ykthink.jewelry.model.cms.commodity.bo.CmsShelfCommodityBO;
import cn.ykthink.jewelry.model.cms.commodity.vo.CmsCommodityListVO;
import cn.ykthink.jewelry.model.common.vo.CommonCategoryVO;
import cn.ykthink.jewelry.model.common.vo.CommonCommodityInfoVO;
import cn.ykthink.jewelry.model.common.vo.CommonJewelryInfoVO;
import cn.ykthink.jewelry.model.common.vo.CommonJewelryListVO;
import cn.ykthink.jewelry.service.cms.CmsCommodityService;
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


    /**
     * get 类目列表
     */
    @GetMapping("category")
    @ApiOperation(value = "类目列表", response = CommonCategoryVO.class)
    public ResponseEntity<Object> category() {
        return cmsCommodityService.category();
    }

    @GetMapping("commodityList")
    @ApiOperation(value = "商品列表", response = CmsCommodityListVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "categoryUuid", value = "类目uuid", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "第几页", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "显示多少条", required = false)
    })
    public ResponseEntity<Object> commodityList(
            @RequestParam(required = false) String categoryUuid,
            @ParameterValid(type = Integer.class, msg = "pageNum不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_index}") Integer pageNum,
            @ParameterValid(type = Integer.class, msg = "pageSize不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_size}") Integer pageSize) {
        return cmsCommodityService.commodityList(categoryUuid, pageNum, pageSize);
    }

    /**
     * 商品详情
     *
     * @param commodityUuid
     * @return
     */
    @GetMapping("commodity/{commodityUuid}")
    @ApiOperation(value = "商品详情", response = CommonCommodityInfoVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "commodityUuid", value = "商品uuid", required = true),
    })
    public ResponseEntity<Object> commodity(@PathVariable String commodityUuid) {
        return cmsCommodityService.commodity(commodityUuid);
    }


    /**
     * get 钻石列表
     */
    @GetMapping("jewelryList")
    @ApiOperation(value = "钻石列表", response = CommonJewelryListVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageNum", value = "第几页", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "pageSize", value = "显示多少条", required = false)
    })
    public ResponseEntity<Object> jewelryList(@ParameterValid(type = Integer.class, msg = "pageNum不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_index}") Integer pageNum,
                                              @ParameterValid(type = Integer.class, msg = "pageSize不能为空", isMin = true) @RequestParam(defaultValue = "${jewelry.pages.page_size}") Integer pageSize) {
        return cmsCommodityService.jewelryList(pageNum, pageSize);
    }

    /**
     * get 钻石详情
     */
    @GetMapping("jewelry/{jewelryUuid}")
    @ApiOperation(value = "钻石详情", response = CommonJewelryInfoVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "jewelryUuid", value = "钻石uuid", required = true),
    })
    public ResponseEntity<Object> jewelryInfo(@PathVariable String jewelryUuid) {
        return cmsCommodityService.jewelryInfo(jewelryUuid);
    }

    /**
     * 上传商品
     *
     * @param body
     * @return
     */
    @PostMapping("commodity")
    @ApiOperation(value = "上传商品", response = ResponseEntity.class)
    public ResponseEntity<Object> addCommodity(@RequestBody CmsCommodityBO body) {
        return null;
    }

    @PutMapping("commodityStatus/{commodityUuid}")
    @ApiOperation(value = "上/下架商品", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "commodityUuid", value = "商品uuid", required = true),
    })
    public ResponseEntity<Object> shelfCommodity(@PathVariable String commodityUuid, @RequestBody CmsShelfCommodityBO body) {
        return null;
    }

    @DeleteMapping("commodity/{commodityUuid}")
    @ApiOperation(value = "删除商品", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "commodityUuid", value = "商品uuid", required = true),
    })
    public ResponseEntity<Object> removeCommodity(@PathVariable String commodityUuid) {
        return null;
    }

    @PutMapping("commodity/{commodityUuid}")
    @ApiOperation(value = "修改商品信息", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "commodityUuid", value = "商品uuid", required = true),
    })
    public ResponseEntity<Object> modifyCommodity(@PathVariable String commodityUuid, @RequestBody CmsShelfCommodityBO body) {
        return null;
    }

}
