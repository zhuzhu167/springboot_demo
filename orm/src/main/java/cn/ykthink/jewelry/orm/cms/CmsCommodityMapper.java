package cn.ykthink.jewelry.orm.cms;

import cn.ykthink.jewelry.model.cms.commodity.bo.CmsTextureBO;
import cn.ykthink.jewelry.model.cms.commodity.vo.CmsTextureListVO;
import cn.ykthink.jewelry.model.common.po.CategoryPO;
import cn.ykthink.jewelry.model.common.po.TexturePO;
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
     * 删除类目
     *
     * @param categoryUuid
     */
    Integer removeCategory(String categoryUuid);

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
     * 删除材质
     *
     * @param textureUuid
     */
    Integer removeTexture(String textureUuid);

    /**
     * 修改材质信息
     *
     * @param textureUuid
     * @param texturePO
     */
    Integer updateTexture(@Param("textureUuid") String textureUuid, @Param("texturePO") TexturePO texturePO);
}
