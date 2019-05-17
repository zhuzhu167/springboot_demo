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
@Order(2)
@Aspect
@Component
public class PcPermissionAspect {

    @Around("@annotation(validatePcPermission)")
    public Object around(ProceedingJoinPoint joinPoint, ValidatePcPermission validatePcPermission) {
        return null;
    }
}
