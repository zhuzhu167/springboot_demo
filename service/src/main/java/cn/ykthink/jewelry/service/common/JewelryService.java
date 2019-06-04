package cn.ykthink.jewelry.service.common;

import org.springframework.http.ResponseEntity;

/**
 * Author: YK
 * Title: JewelryService
 * Description: 珠宝控制器
 * Date: 2019/6/4
 * Time: 17:49
 */
public interface JewelryService {
    /**
     * 获取
     * @return
     */
    ResponseEntity<Object> qnyToken();
}
