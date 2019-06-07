package cn.ykthink.jewelry.service.cms;

import cn.ykthink.jewelry.model.cms.commodity.bo.CmsCategoryBO;
import cn.ykthink.jewelry.model.cms.commodity.bo.CmsTextureBO;
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
}
