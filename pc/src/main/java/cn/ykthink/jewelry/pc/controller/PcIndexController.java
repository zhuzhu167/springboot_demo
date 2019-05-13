package cn.ykthink.jewelry.pc.controller;

import cn.ykthink.jewelry.core.annotation.ValidatePcPermission;
import cn.ykthink.jewelry.core.annotation.validateEnums.ValidatePcPermissionEnum;
import cn.ykthink.jewelry.model.pc.index.PcIndexCategoryVO;
import cn.ykthink.jewelry.service.pc.PcIndexService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * Author: YK
 * Title: PcIndexController
 * Description: 首页控制器
 * Date: 2019/5/13
 * Time: 10:53
 */
@Controller
public class PcIndexController {
    @Resource
    PcIndexService pcIndexService;

    /**
     * get 类目列表
     */
    @ValidatePcPermission(validatePcPermissionEnum = ValidatePcPermissionEnum.PC_USER)
    @GetMapping("category")
    @ApiOperation(value = "类目列表", response = PcIndexCategoryVO.class)
    public ResponseEntity<Object> category() {
        return pcIndexService.category();
    }
}
