package cn.ykthink.jewelry.service.cms.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.model.cms.commodity.bo.CmsCategoryBO;
import cn.ykthink.jewelry.model.cms.commodity.bo.CmsTextureBO;
import cn.ykthink.jewelry.model.common.po.CategoryPO;
import cn.ykthink.jewelry.model.common.po.TexturePO;
import cn.ykthink.jewelry.orm.cms.CmsCommodityMapper;
import cn.ykthink.jewelry.service.cms.CmsCommodityService;
import cn.ykthink.jewelry.service.common.CommonCommodityService;
import org.springframework.http.HttpStatus;
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

    @Override
    public ResponseEntity<Object> addCategory(CmsCategoryBO body) {
        CategoryPO categoryPO = new CategoryPO();
        categoryPO.setCategory(body.getCategory());
        categoryPO.setCopywriting(body.getCopywriting());
        categoryPO.setSort(body.getSort());
        cmsCommodityMapper.insertCategory(categoryPO);
        return ResponseEntitySupport.success();
    }

    @Override
    public ResponseEntity<Object> removeCategory(String categoryUuid) {
        if (cmsCommodityMapper.removeCategory(categoryUuid) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
        }
    }

    @Override
    public ResponseEntity<Object> updateCategory(String categoryUuid, CmsCategoryBO body) {
        CategoryPO categoryPO = new CategoryPO();
        categoryPO.setCategory(body.getCategory());
        categoryPO.setCopywriting(body.getCopywriting());
        categoryPO.setSort(body.getSort());
        if (cmsCommodityMapper.updateCategory(categoryUuid, categoryPO) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
        }
    }

    @Override
    public ResponseEntity<Object> texture() {
        return ResponseEntitySupport.success(cmsCommodityMapper.selectTexture());
    }

    @Override
    public ResponseEntity<Object> addTexture(CmsTextureBO body) {
        TexturePO texturePO = new TexturePO();
        texturePO.setTextureName(body.getTextureName());
        cmsCommodityMapper.addTexture(texturePO);
        return ResponseEntitySupport.success();
    }

    @Override
    public ResponseEntity<Object> removeTexture(String textureUuid) {
        if (cmsCommodityMapper.removeTexture(textureUuid) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
        }
    }

    @Override
    public ResponseEntity<Object> updateTexture(String textureUuid, CmsTextureBO body) {
        TexturePO texturePO = new TexturePO();
        texturePO.setTextureName(body.getTextureName());
        if (cmsCommodityMapper.updateTexture(textureUuid, texturePO) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
        }
    }
}
