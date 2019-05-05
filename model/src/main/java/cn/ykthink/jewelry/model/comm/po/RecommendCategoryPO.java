package cn.ykthink.jewelry.model.comm.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * program: jewelry
 * description:推荐类目PO
 * author: mi
 * create: 2019-05-05 18:05
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class RecommendCategoryPO extends BasePO {
    /**
     *推荐类别号
     */
    private Integer type;
}
