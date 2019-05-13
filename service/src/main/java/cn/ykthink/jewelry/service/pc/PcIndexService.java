package cn.ykthink.jewelry.service.pc;

import org.springframework.http.ResponseEntity;

/**
 * Author: YK
 * Title: PcIndexService
 * Description: 首页Service
 * Date: 2019/5/13
 * Time: 11:09
 */
public interface PcIndexService {
    /**
     * 类目列表
     * @return
     */
    ResponseEntity<Object> category();
}
