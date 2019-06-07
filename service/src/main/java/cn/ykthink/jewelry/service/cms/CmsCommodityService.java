package cn.ykthink.jewelry.service.cms;

import cn.ykthink.jewelry.model.cms.commodity.bo.*;
import org.springframework.http.ResponseEntity;

/**
 * Author: YK
 * Title: CmsCommodityService
 * Description: 商家商品控制器
 * Date: 2019/6/3
 * Time: 23:35
 */
public interface CmsCommodityService {
    /**
     * 商品列表
     *
     * @return
     */
    ResponseEntity<Object> commodityList(String categoryUuid, Integer pageNum, Integer pageSize);

    /**
     * 商品详情
     *
     * @return
     */
    ResponseEntity<Object> commodity(String commodityUuid);

    /**
     * 钻石列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseEntity<Object> jewelryList(Integer pageNum, Integer pageSize);

    /**
     * 钻石详情
     *
     * @param jewelryUuid
     * @return
     */
    ResponseEntity<Object> jewelryInfo(String jewelryUuid);

    /**
     * 类目列表
     *
     * @return
     */
    ResponseEntity<Object> category();

    /**
     * 新增类目
     *
     * @param body
     * @return
     */
    ResponseEntity<Object> addCategory(CmsCategoryBO body);

    /**
     * 删除类目
     *
     * @param categoryUuid
     * @return
     */
    ResponseEntity<Object> removeCategory(String categoryUuid);

    /**
     * 修改类目信息
     *
     * @param categoryUuid
     * @param body
     * @return
     */
    ResponseEntity<Object> updateCategory(String categoryUuid, CmsCategoryBO body);

    /**
     * 获取材质类别
     *
     * @return
     */
    ResponseEntity<Object> texture();

    /**
     * 新增材质
     *
     * @param body
     * @return
     */
    ResponseEntity<Object> addTexture(CmsTextureBO body);

    /**
     * 删除材质
     *
     * @param textureUuid
     * @return
     */
    ResponseEntity<Object> removeTexture(String textureUuid);

    /**
     * 修改材质信息
     *
     * @param textureUuid
     * @param body
     * @return
     */
    ResponseEntity<Object> updateTexture(String textureUuid, CmsTextureBO body);

    /**
     * 新增钻石
     *
     * @param body
     * @return
     */
    ResponseEntity<Object> addJewelry(CmsJewelryBO body);

    /**
     * 修改钻石信息
     *
     * @param jewelryUuid
     * @param body
     * @return
     */
    ResponseEntity<Object> modifyJewelry(String jewelryUuid, CmsJewelryBO body);

    /**
     * 删除钻石
     *
     * @param jewelryUuid
     * @return
     */
    ResponseEntity<Object> removeJewelry(String jewelryUuid);

    /**
     * 删除商品
     *
     * @param commodityUuid
     * @return
     */
    ResponseEntity<Object> removeCommodity(String commodityUuid);

    /**
     * 上下架商品
     *
     * @param commodityUuid
     * @param body
     * @return
     */
    ResponseEntity<Object> shelfCommodity(String commodityUuid, CmsShelfCommodityBO body);

    /**
     * 新增商品
     *
     * @param body
     * @return
     */
    ResponseEntity<Object> addCommodity(CmsCommodityBO body);

    /**
     * 修改商品信息
     *
     * @param commodityUuid
     * @param body
     * @return
     */
    ResponseEntity<Object> modifyCommodity(String commodityUuid, CmsCommodityBO body);
}
