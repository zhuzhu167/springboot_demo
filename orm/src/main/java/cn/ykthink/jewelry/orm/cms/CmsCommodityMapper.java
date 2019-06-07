package cn.ykthink.jewelry.orm.cms;

import cn.ykthink.jewelry.model.cms.commodity.bo.CmsCommodityJewelryImageBO;
import cn.ykthink.jewelry.model.cms.commodity.bo.CmsTextureBO;
import cn.ykthink.jewelry.model.cms.commodity.vo.CmsTextureListVO;
import cn.ykthink.jewelry.model.common.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: YK
 * Title: CmsCommodityMapper
 * Description: 商家商品Mapper
 * Date: 2019/6/3
 * Time: 23:36
 */
@Mapper
@Repository
public interface CmsCommodityMapper {
    /**
     * 新增类目
     *
     * @param categoryPO
     * @return
     */
    Integer insertCategory(CategoryPO categoryPO);

    /**
     * 修改类目信息
     *
     * @param categoryUuid
     * @param categoryPO
     * @return
     */
    Integer updateCategory(@Param("categoryUuid") String categoryUuid, @Param("categoryPO") CategoryPO categoryPO);

    /**
     * 材质列表
     *
     * @return
     */
    List<CmsTextureListVO> selectTexture();

    /**
     * 新增材质
     *
     * @param texturePO
     */
    Integer addTexture(TexturePO texturePO);

    /**
     * 修改材质信息
     *
     * @param textureUuid
     * @param texturePO
     */
    Integer updateTexture(@Param("textureUuid") String textureUuid, @Param("texturePO") TexturePO texturePO);

    /**
     * 新增钻石信息
     *
     * @param jewelryPO
     */
    Integer addJewelry(JewelryPO jewelryPO);


    /**
     * 逻辑删除
     *
     * @param tableName
     * @param uuid
     * @return
     */
    Integer removeIsDeleted(@Param("tableName") String tableName, @Param("uuid") String uuid);

    /**
     * 更新钻石信息
     *
     * @param jewelryPO
     */
    Integer modifyJewelry(JewelryPO jewelryPO);

    /**
     * 插入图片
     *
     * @param imageList
     */
    Integer addImage(@Param("commodityJewelryUuid") String commodityJewelryUuid, @Param("imageList") List<CmsCommodityJewelryImageBO> imageList);

    /**
     * 删除图片
     *
     * @param commodityJewelryUuid
     * @return
     */
    Integer removeImage(@Param("commodityJewelryUuid") String commodityJewelryUuid);

    /**
     * 恢复图片
     *
     * @param imageUuid
     * @return
     */
    Integer restoreImage(String imageUuid);

    /**
     * 上下架商品
     *
     * @param commodityUuid
     * @param commodityStatus
     */
    Integer shelfCommodity(String commodityUuid, Integer commodityStatus);

    /**
     * 生成库存
     *
     * @param storePO
     * @return
     */
    Integer addStore(StorePO storePO);

    /**
     * @param commodityPO
     */
    Integer addCommodity(CommodityPO commodityPO);

    /**
     * 更新商品信息
     *
     * @param commodityPO
     * @return
     */
    Integer updateCommodity(CommodityPO commodityPO);

    /**
     * 更新库存
     *
     * @param commodityUuid
     * @param store
     */
    void updateStore(@Param("commodityUuid") String commodityUuid, @Param("store") Integer store);
}
