package cn.ykthink.jewelry.cms.aspect.permission;

import cn.ykthink.jewelry.core.annotation.IgnoreToken;
import cn.ykthink.jewelry.core.annotation.ValidatePcPermission;
import cn.ykthink.jewelry.core.aspect.JWT.JWTokenAspect;
import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: YK
 * Title: CmsPermissionAspect
 * Description: 用户端切面
 * Date: 2019/4/3
 * Time: 2:51
 */
@Slf4j
@Order(2)
@Aspect
@Component
public class CmsPermissionAspect {

    @Resource
    private HttpServletRequest request;

    private final String POINT_CUT = "execution(* cn.ykthink.jewelry.cms.controller..*(..))";

    @Around(POINT_CUT)
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取当前执行的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //判断当前执行的方法是否存在IgnoreToken注解
        if (signature.getMethod().isAnnotationPresent(IgnoreToken.class)) {
            //放行
            return joinPoint.proceed();
        }
        String token = request.getHeader("X-Access-Token");
        String identity = JWTokenUtil.validateJWToken(token, "identity");
        if (StringUtils.isNotBlank(identity) && identity.equals("admin")) {
            return joinPoint.proceed();
        } else {
            return ResponseEntitySupport.error(HttpStatus.UNAUTHORIZED, "无管理员权限", "No administrator rights");
        }
    }
}
