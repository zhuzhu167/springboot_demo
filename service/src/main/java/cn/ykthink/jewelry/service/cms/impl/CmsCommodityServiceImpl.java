package cn.ykthink.jewelry.service.cms.impl;

import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.model.cms.commodity.bo.*;
import cn.ykthink.jewelry.model.common.po.*;
import cn.ykthink.jewelry.orm.cms.CmsCommodityMapper;
import cn.ykthink.jewelry.service.cms.CmsCommodityService;
import cn.ykthink.jewelry.service.common.CommonCommodityService;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
        return ResponseEntitySupport.success(commonCommodityService.commodityList(categoryUuid, null, pageNum, pageSize));
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
        categoryPO.setCategory(body.getCategoryName());
        categoryPO.setCopywriting(body.getCopywriting());
        categoryPO.setSort(body.getSort());
        cmsCommodityMapper.insertCategory(categoryPO);
        return ResponseEntitySupport.success();
    }

    @Override
    public ResponseEntity<Object> removeCategory(String categoryUuid) {
        if (cmsCommodityMapper.checkoutCommodityNum(categoryUuid) > 0
        ) {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "请先将所有商品清除后再删除该类目", "Please clear all items before deleting the category.");
        }
        if (cmsCommodityMapper.removeIsDeleted("category", categoryUuid) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
        }
    }

    @Override
    public ResponseEntity<Object> updateCategory(String categoryUuid, CmsCategoryBO body) {
        CategoryPO categoryPO = new CategoryPO();
        categoryPO.setCategory(body.getCategoryName());
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
        if (cmsCommodityMapper.removeIsDeleted("texture", textureUuid) > 0) {
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

    @Override
    @Transactional
    public ResponseEntity<Object> addJewelry(CmsJewelryBO body) {
        //设置JewelryNo
        Random r = new Random();
        Integer t = r.nextInt(9999);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String jewelryNo = sdf.format(date) + t.toString();
        JewelryPO jewelryPO = new JewelryPO();
        jewelryPO.setClarity(body.getClarity());
        jewelryPO.setColor(body.getColor());
        jewelryPO.setCut(body.getCut());
        jewelryPO.setJewelryNo(jewelryNo);
        jewelryPO.setJewelryPrice(body.getJewelryPrice());
        jewelryPO.setLight(body.getLight());
        jewelryPO.setPolishing(body.getPolishing());
        jewelryPO.setShape(body.getShape());
        //生成钻石
        cmsCommodityMapper.addJewelry(jewelryPO);
        //插入图片
        cmsCommodityMapper.addImage(jewelryPO.getUuid(), body.getImageList());
        return ResponseEntitySupport.success();
    }

    @Override
    public ResponseEntity<Object> modifyJewelry(String jewelryUuid, CmsJewelryBO body) {
        //先逻辑删除所有图片
        cmsCommodityMapper.removeImage(jewelryUuid);
        JewelryPO jewelryPO = new JewelryPO();
        jewelryPO.setClarity(body.getClarity());
        jewelryPO.setColor(body.getColor());
        jewelryPO.setCut(body.getCut());
        jewelryPO.setJewelryPrice(body.getJewelryPrice());
        jewelryPO.setLight(body.getLight());
        jewelryPO.setPolishing(body.getPolishing());
        jewelryPO.setShape(body.getShape());
        jewelryPO.setUuid(jewelryUuid);
        cmsCommodityMapper.modifyJewelry(jewelryPO);
        //更新图片
        updateImage(jewelryUuid, body.getImageList());
        return ResponseEntitySupport.success();
    }

    @Override
    public ResponseEntity<Object> removeJewelry(String jewelryUuid) {
        if (cmsCommodityMapper.removeIsDeleted("jewelry", jewelryUuid) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
        }
    }

    @Override
    public ResponseEntity<Object> removeCommodity(String commodityUuid) {
        if (cmsCommodityMapper.removeIsDeleted("commodity", commodityUuid) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
        }
    }

    @Override
    public ResponseEntity<Object> shelfCommodity(String commodityUuid, CmsShelfCommodityBO body) {
        if (cmsCommodityMapper.shelfCommodity(commodityUuid, body.getCommodityStatus()) > 0) {
            return ResponseEntitySupport.success();
        } else {
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, "数据异常", "Abnormal data");
        }
    }

    @Override
    @Transactional
    public ResponseEntity<Object> addCommodity(CmsCommodityBO body) {
        //设置CommodityNo
        Random r = new Random();
        Integer t = r.nextInt(9999);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String commodityNo = sdf.format(date) + t.toString();
        CommodityPO commodityPO = new CommodityPO();
        commodityPO.setCategoryUuid(body.getCategoryUuid());
        commodityPO.setCommodityPrice(body.getCommodityPrice());
        commodityPO.setCommodityNo(commodityNo);
        commodityPO.setDetail(body.getDetail());
        commodityPO.setSubhead(body.getSubhead());
        commodityPO.setTextureUuid(body.getTextureUuid());
        commodityPO.setTitle(body.getTitle());
        //生成库存
        StorePO storePO = new StorePO();
        storePO.setStoreConsumption(body.getStore());
        cmsCommodityMapper.addStore(storePO);
        commodityPO.setStoreUuid(storePO.getUuid());
        //生成商品
        cmsCommodityMapper.addCommodity(commodityPO);
        //插入图片
        cmsCommodityMapper.addImage(commodityPO.getUuid(), body.getImageList());
        return ResponseEntitySupport.success();
    }

    @Override
    @Transactional
    public ResponseEntity<Object> modifyCommodity(String commodityUuid, CmsCommodityBO body) {
        //先逻辑删除所有图片
        cmsCommodityMapper.removeImage(commodityUuid);
        CommodityPO commodityPO = new CommodityPO();
        commodityPO.setUuid(commodityUuid);
        commodityPO.setCommodityPrice(body.getCommodityPrice());
        commodityPO.setDetail(body.getDetail());
        commodityPO.setSubhead(body.getSubhead());
        commodityPO.setCategoryUuid(body.getCategoryUuid());
        commodityPO.setTextureUuid(body.getTextureUuid());
        commodityPO.setTitle(body.getTitle());
        //更新商品信息
        cmsCommodityMapper.updateCommodity(commodityPO);
        //更新库存
        cmsCommodityMapper.updateStore(commodityUuid, body.getStore());
        //更新图片
        updateImage(commodityUuid, body.getImageList());
        return ResponseEntitySupport.success();
    }

    private void updateImage(String uuid, List<CmsCommodityJewelryImageBO> ImageList) {
        if (ImageList != null && ImageList.size() > 0) {
            Iterator<CmsCommodityJewelryImageBO> ImageListIterator = ImageList.iterator();
            while (ImageListIterator.hasNext()) {
                CmsCommodityJewelryImageBO image = ImageListIterator.next();
                if (StringUtils.isNotBlank(image.getImageUuid()) && StringUtils.isNotBlank(image.getImageUrl())) {
                    //uuid和图片地址都不为空是修改图片
                    cmsCommodityMapper.restoreImage(image.getImageUuid(), image.getImageUrl());
                    ImageListIterator.remove();
                } else if (StringUtils.isBlank(image.getImageUrl())) {
                    //图片地址为空是删除图片
                    ImageListIterator.remove();
                }
            }
            if (ImageList.size() > 0) {
                cmsCommodityMapper.addImage(uuid, ImageList);
            }
        }
    }
}
