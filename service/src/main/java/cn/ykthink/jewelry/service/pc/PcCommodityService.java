package cn.ykthink.jewelry.service.pc;

import org.springframework.http.ResponseEntity;

/**
 * program: jewelry
 * description:商品Service
 * author: mi
 * create: 2019-05-14 17:40
 **/
public interface PcCommodityService {
    /**
     * 商品简介
     * @return
     */
    ResponseEntity<Object> commodityIntroduction();
}
