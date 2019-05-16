package cn.ykthink.jewelry.pc.aspect.permission;

import cn.ykthink.jewelry.core.annotation.ValidatePcPermission;
import cn.ykthink.jewelry.core.constant.HttpResponseConstant;
import cn.ykthink.jewelry.core.support.http.AbstractHttpSupport;
import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import cn.ykthink.jewelry.core.untils.JWTokenUtil;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: YK
 * Title: PcAspect
 * Description: 用户端切面
 * Date: 2019/4/3
 * Time: 2:51
 */
@Slf4j
@Order(1)
@Aspect
@Component
public class PcPermissionAspect {
    @Value("${jewelry.jwt.key}")
    private String KEY;

    @Around("@annotation(validatePcPermission)")
    public Object around(ProceedingJoinPoint joinPoint, ValidatePcPermission validatePcPermission) {
        try {
        ServletRequestAttributes res = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = res.getRequest();
        HttpServletResponse response = res.getResponse();
        String token = request.getHeader("X-Access-Token");
        if (StringUtils.isBlank(token)) {
            return ResponseEntitySupport.error(HttpStatus.PRECONDITION_FAILED, HttpResponseConstant.HTTP_MESSAGE_PRECONDITION_FAILED, "X-Access-Token Defect");
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
        return joinPoint.proceed();
    } catch (Throwable throwable) {
        throwable.printStackTrace();
        return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, HttpResponseConstant.HTTP_MESSAGE_INTERNAL_SERVER_ERROR, "网络繁忙");
    }
}
}
