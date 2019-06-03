package cn.ykthink.jewelry.model.common.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * program: jewelry
 * description:
 * author: mi
 * create: 2019-05-05 19:38
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryPO extends BasePO{
    /**
     * 类目名称
     */
    private String category;
    /**
     * 排序
     */
    private Integer sort;
}
