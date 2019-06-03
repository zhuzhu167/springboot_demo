package cn.ykthink.jewelry.model.common.po;

import lombok.Data;

/**
 * Author: YK
 * Title: BasePO
 * Description: PO基础类
 * Date: 2019/4/28
 * Time: 15:05
 */
@Data
public class BasePO {
    /**
     * 主键
     */
    private String uuid;
    /**
     * 是否删除0-否1-是
     */
    private Integer isDeleted;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String modifiedTime;
}
