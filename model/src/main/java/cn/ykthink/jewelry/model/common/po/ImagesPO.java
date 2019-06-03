package cn.ykthink.jewelry.model.common.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * program: jewelry
 * description:图片PO
 * author: mi
 * create: 2019-05-05 19:19
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class ImagesPO extends BasePO {
    /**
     * 图片路径
     */
    private String imageUrl;
    /**
     * 图片序号
     */
    private Integer imageNumber;
    /**
     * 商品钻石uuid
     */
    private String commodityJewelryUuid;
    /**
     * 类目uuid
     */
    private String categoryUuid;
    /**
     * 推荐类目uuid
     */
    private String recommendCategoryUuid;

}
