package cn.ykthink.jewelry.service.cms.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.orm.cms.CmsCommodityMapper;
import cn.ykthink.jewelry.service.cms.CmsCommodityService;
import cn.ykthink.jewelry.service.common.CommonCommodityService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: YK
 * Title: CmsCommodityServiceImpl
 * Description: 商家商品service实现类
 * Date: 2019/6/3
 * Time: 23:04
 */
@Service
public class CmsCommodityServiceImpl implements CmsCommodityService {
    @Resource
    CommonCommodityService commonCommodityService;
    @Resource
    CmsCommodityMapper cmsCommodityMapper;

    @Override
    public ResponseEntity<Object> commodityList(String categoryUuid, Integer pageNum, Integer pageSize) {
        return ResponseEntitySupport.success(commonCommodityService.commodityList(categoryUuid, pageNum, pageSize));
    }

    @Override
    public ResponseEntity<Object> commodity(String commodityUuid) {
        return ResponseEntitySupport.success(commonCommodityService.commodity(commodityUuid));
    }

    @Override
    public ResponseEntity<Object> jewelryList(Integer pageNum, Integer pageSize) {
        return ResponseEntitySupport.success(commonCommodityService.jewelryList(pageNum, pageSize));
    }

    @Override
    public ResponseEntity<Object> jewelryInfo(String jewelryUuid) {
        return ResponseEntitySupport.success(commonCommodityService.jewelryInfo(jewelryUuid));
    }

    @Override
    public ResponseEntity<Object> category() {
        return ResponseEntitySupport.success(commonCommodityService.category());
    }
}
