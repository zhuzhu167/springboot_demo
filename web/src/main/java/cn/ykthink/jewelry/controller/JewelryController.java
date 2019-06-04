package cn.ykthink.jewelry.controller;

import cn.ykthink.jewelry.core.uri.SystemUri;
import cn.ykthink.jewelry.model.common.vo.CommonJewelryListVO;
import cn.ykthink.jewelry.model.common.vo.CommonQnyTokenConfigVO;
import cn.ykthink.jewelry.service.common.JewelryService;
import com.github.catalpaflat.valid.annotation.ParameterValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author: YK
 * Title: Conrtoller
 * Description: 控制器
 * Date: 2019/6/4
 * Time: 17:39
 */
@RestController
@Api(description = "七牛云")
@RequestMapping("qny")
public class JewelryController {
    @Resource
    JewelryService jewelryService;



    @GetMapping("qnyToken")
    @ApiOperation(value = "七牛云token配制", response = CommonQnyTokenConfigVO.class)
    public ResponseEntity<Object> qnyToken() {
        return jewelryService.qnyToken();
    }
}
