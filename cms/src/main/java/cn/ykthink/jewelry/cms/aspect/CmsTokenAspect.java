package cn.ykthink.jewelry.cms.aspect;


import cn.ykthink.jewelry.core.aspect.JWT.JWTokenAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Author: YK
 * Title: CmsTokenAspect
 * Description: token校验切面
 * Date: 2019/3/13
 * Time: 14:11
 */
@Slf4j
@Aspect
@Order(1)
@Component
public class CmsTokenAspect {

    @Resource
    private JWTokenAspect jwTokenAspect;

    private final String POINT_CUT = "execution(* cn.ykthink.jewelry.cms.controller..*(..))";

    @Around(POINT_CUT)
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //基础全局JWToken鉴权
        return jwTokenAspect.validateToken(joinPoint);
    }



    @Pointcut(POINT_CUT)
    private void pointcut() {
    }

}
