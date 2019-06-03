package cn.ykthink.jewelry.core.aspect.JWT;


import cn.ykthink.jewelry.core.annotation.IgnoreToken;
import cn.ykthink.jewelry.core.constant.HttpResponseConstant;
import cn.ykthink.jewelry.core.support.http.AbstractHttpSupport;
import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: YK
 * Title: JWTokenAspectSupport
 * Description: JWToken校验
 * Date: 2019/4/3
 * Time: 2:51
 */
@Component
public class JWTokenAspect {

    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;

    public  Object validateToken(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取当前执行的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //判断当前执行的方法是否存在IgnoreToken注解
        if (signature.getMethod().isAnnotationPresent(IgnoreToken.class)) {
            //放行
            return joinPoint.proceed();
        }
        try {
            String token = request.getHeader("X-Access-Token");
            if (StringUtils.isBlank(token)) {
                return ResponseEntitySupport.error(HttpStatus.UNAUTHORIZED, HttpResponseConstant.HTTP_MESSAGE_PRECONDITION_FAILED, "X-Access-Token Defect");
            }
            //判断token是否过期
            try {
                String uuid = JWTokenUtil.validateJWToken(token, "uuid");
                if (StringUtils.isBlank(uuid)) {
                    return ResponseEntitySupport.error(HttpStatus.UNAUTHORIZED, "无效的用户", "Invalid token");
                }
            } catch (IllegalStateException e) {
                return ResponseEntitySupport.error(HttpStatus.UNAUTHORIZED, "无效token", "Invalid token");
            }
            try {
                //进行http预处理
                AbstractHttpSupport.intercept(request, response, joinPoint);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            //放行
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, HttpResponseConstant.HTTP_MESSAGE_INTERNAL_SERVER_ERROR, "网络繁忙");
        }
    }
}
