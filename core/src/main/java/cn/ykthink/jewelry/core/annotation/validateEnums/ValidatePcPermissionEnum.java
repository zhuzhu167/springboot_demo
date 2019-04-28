package cn.ykthink.jewelry.core.annotation.validateEnums;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: YK
 * Title: ValidatePcPermissionEnum
 * Description: 合法PC权限枚举类
 * Date: 2019/4/3
 * Time: 3:14
 */
public enum ValidatePcPermissionEnum {


    /**
     * 用户端
     */
    PC_USER("pc_user");

    @Getter
    @Setter
    public String value;

    ValidatePcPermissionEnum(String value) {
        this.value = value;
    }

}
