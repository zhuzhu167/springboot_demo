package cn.ykthink.jewelry.core.annotation;

import cn.ykthink.jewelry.core.annotation.validateEnums.ValidatePcPermissionEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: YK
 * Title: ValidatePcPermissionEnum
 * Description: pc鉴权注解
 * Date: 2019/4/3
 * Time: 3:14
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidatePcPermission {
    ValidatePcPermissionEnum validatePcPermissionEnum();
}
