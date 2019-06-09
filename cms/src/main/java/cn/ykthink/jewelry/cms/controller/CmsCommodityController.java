package cn.ykthink.jewelry.cms.controller;

import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.cms.commodity.bo.*;
import cn.ykthink.jewelry.model.cms.commodity.vo.CmsCommodityListVO;
import cn.ykthink.jewelry.model.cms.commodity.vo.CmsTextureListVO;
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
import org.springframework.validation.annotation.Validated;
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

    @GetMapping("texture")
    @ApiOperation(value = "材质列表", response = CmsTextureListVO.class)
    public ResponseEntity<Object> texture() {
        return cmsCommodityService.texture();
    }

    @PostMapping("texture")
    @ApiOperation(value = "新增材质", response = ResponseEntity.class)
    public ResponseEntity<Object> addTexture(@RequestBody @Validated CmsTextureBO body) {
        return cmsCommodityService.addTexture(body);
    }

    @DeleteMapping("texture/{textureUuid}")
    @ApiOperation(value = "删除材质", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "textureUuid", value = "材质uuid", required = true),
    })
    public ResponseEntity<Object> removeTexture(@PathVariable String textureUuid) {
        return cmsCommodityService.removeTexture(textureUuid);
    }

    @PutMapping("texture/{textureUuid}")
    @ApiOperation(value = "修改材质", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "textureUuid", value = "材质uuid", required = true),
    })
    public ResponseEntity<Object> updateTexture(@PathVariable String textureUuid, @RequestBody @Validated CmsTextureBO body) {
        return cmsCommodityService.updateTexture(textureUuid, body);
    }

    @GetMapping("category")
    @ApiOperation(value = "类目列表", response = CommonCategoryVO.class)
    public ResponseEntity<Object> category() {
        return cmsCommodityService.category();
    }

    @PostMapping("category")
    @ApiOperation(value = "新增类目", response = ResponseEntity.class)
    public ResponseEntity<Object> addCategory(@RequestBody @Validated CmsCategoryBO body) {
        return cmsCommodityService.addCategory(body);
    }

    @DeleteMapping("category/{categoryUuid}")
    @ApiOperation(value = "删除类目", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "categoryUuid", value = "类目uuid", required = true),
    })
    public ResponseEntity<Object> removeCategory(@PathVariable String categoryUuid) {
        return cmsCommodityService.removeCategory(categoryUuid);
    }

    @PutMapping("category/{categoryUuid}")
    @ApiOperation(value = "修改信息类目", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "categoryUuid", value = "类目uuid", required = true),
    })
    public ResponseEntity<Object> updateCategory(@PathVariable String categoryUuid, @RequestBody @Validated CmsCategoryBO body) {
        return cmsCommodityService.updateCategory(categoryUuid, body);
    }

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

    @GetMapping("jewelry/{jewelryUuid}")
    @ApiOperation(value = "钻石详情", response = CommonJewelryInfoVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "jewelryUuid", value = "钻石uuid", required = true),
    })
    public ResponseEntity<Object> jewelryInfo(@PathVariable String jewelryUuid) {
        return cmsCommodityService.jewelryInfo(jewelryUuid);
    }

    @PostMapping("jewelry")
    @ApiOperation(value = "新增钻石", response = ResponseEntity.class)
    public ResponseEntity<Object> addJewelry(@RequestBody @Validated CmsJewelryBO body) {
        return cmsCommodityService.addJewelry(body);
    }

    @PutMapping("jewelry/{jewelryUuid}")
    @ApiOperation(value = "修改钻石信息", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "jewelryUuid", value = "钻石uuid", required = true),
    })
    public ResponseEntity<Object> modifyJewelry(@PathVariable String jewelryUuid, @RequestBody @Validated CmsJewelryBO body) {
        return cmsCommodityService.modifyJewelry(jewelryUuid,body);
    }

    @DeleteMapping("jewelry/{jewelryUuid}")
    @ApiOperation(value = "删除钻石", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "jewelryUuid", value = "钻石uuid", required = true),
    })
    public ResponseEntity<Object> removeJewelry(@PathVariable String jewelryUuid) {
        return cmsCommodityService.removeJewelry(jewelryUuid);
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

    @GetMapping("commodity/{commodityUuid}")
    @ApiOperation(value = "商品详情", response = CommonCommodityInfoVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "commodityUuid", value = "商品uuid", required = true),
    })
    public ResponseEntity<Object> commodity(@PathVariable String commodityUuid) {
        return cmsCommodityService.commodity(commodityUuid);
    }

    @PostMapping("commodity")
    @ApiOperation(value = "新增商品", response = ResponseEntity.class)
    public ResponseEntity<Object> addCommodity(@RequestBody @Validated  CmsCommodityBO body) {
        return cmsCommodityService.addCommodity(body);
    }

    @PutMapping("commodityStatus/{commodityUuid}")
    @ApiOperation(value = "上/下架商品", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "commodityUuid", value = "商品uuid", required = true),
    })
    public ResponseEntity<Object> shelfCommodity(@PathVariable String commodityUuid, @RequestBody  @Validated CmsShelfCommodityBO body) {
        return cmsCommodityService.shelfCommodity(commodityUuid,body);
    }

    @DeleteMapping("commodity/{commodityUuid}")
    @ApiOperation(value = "删除商品", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "commodityUuid", value = "商品uuid", required = true),
    })
    public ResponseEntity<Object> removeCommodity(@PathVariable @Validated String commodityUuid) {
        return cmsCommodityService.removeCommodity(commodityUuid);
    }

    @PutMapping("commodity/{commodityUuid}")
    @ApiOperation(value = "修改商品信息", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "String", name = "commodityUuid", value = "商品uuid", required = true),
    })
    public ResponseEntity<Object> modifyCommodity(@PathVariable  String commodityUuid, @RequestBody @Validated CmsCommodityBO body) {
        return cmsCommodityService.modifyCommodity(commodityUuid,body);
    }

}
