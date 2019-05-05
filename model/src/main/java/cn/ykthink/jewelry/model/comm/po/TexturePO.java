package cn.ykthink.jewelry.model.comm.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * program: jewelry
 * description:材质PO
 * author: mi
 * create: 2019-05-05 18:00
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class TexturePO extends BasePO{
    /**
     * 材质名称
     */
    private String textureName;
}
