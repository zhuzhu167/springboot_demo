package cn.ykthink.jewelry.pc.controller;

import cn.ykthink.jewelry.core.annotation.ValidatePcPermission;
import cn.ykthink.jewelry.core.annotation.validateEnums.ValidatePcPermissionEnum;
import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.pc.user.vo.PcUserCommodityIntroductionVO;
import cn.ykthink.jewelry.service.pc.PcCommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<Object> category() {
        return pcCommodityService.commodityIntroduction();
    }
    /**
     * get 商品详情
     */

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
