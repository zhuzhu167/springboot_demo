package cn.ykthink.jewelry.model.comm.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * program: jewelry
 * description:商品PO
 * author: mi
 * create: 2019-05-05 19:27
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class CommodityPO extends BasePO{
    /**
     * 材质uuid
     */
    private String textureUuid;
    /**
     * 库存uuid
     */
    private String storeUuid;
    /**
     * 类目uuid
     */
    private String categoryUuid;
    /**
     * 商品状态
     */
    private String commodityStatus;
    /**
     * 商品编号
     */
    private String commodityNo;
    /**
     * 商品价格
     */
    private BigDecimal commodityPrice;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品副标题
     */
    private String subhead;
    /**
     * 商品详情
     */
    private String detail;
}
