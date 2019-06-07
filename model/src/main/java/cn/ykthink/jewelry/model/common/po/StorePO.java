package cn.ykthink.jewelry.model.common.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * program: jewelry
 * description:库存PO
 * author: mi
 * create: 2019-05-05 18:02
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class StorePO extends BasePO {
    /**
     * 库存剩余量
     */
    private Integer storeConsumption;
}
