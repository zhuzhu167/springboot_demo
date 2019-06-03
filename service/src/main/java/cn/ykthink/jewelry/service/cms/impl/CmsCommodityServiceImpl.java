package cn.ykthink.jewelry.service.cms.impl;

import cn.ykthink.jewelry.orm.cms.CmsCommodityMapper;
import cn.ykthink.jewelry.service.cms.CmsCommodityService;
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
    CmsCommodityMapper cmsCommodityMapper;

    @Override
    public ResponseEntity<Object> commodityList(String categoryUuid, Integer pageNum, Integer pageSize) {
        return null;
    }
}
