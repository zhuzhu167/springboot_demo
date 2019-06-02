package cn.ykthink.jewelry.core.untils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * Author: YK
 * Title: JwtTokenUtil
 * Description: JWT 工具类
 * Date: 2019/3/2
 * Time: 18:07
 */
@Component
public class JWTokenUtil {

    private static String KEY;

    @Value("${jewelry.jwt.key}")
    public void setKey(String key) {
        KEY = key;
    }

    /**
     * /**
     * 生成JWToken
     *
     * @param map
     * @param expirationTime
     * @return
     */
    public static String generateJWToken(Map<String, Object> map, long expirationTime) {
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))// 1000 hour
                .signWith(SignatureAlgorithm.HS512, KEY)
                .compact();
        return jwt; //jwt前面一般都会加Bearer
    }


    /**
     * 校验JWToken
     *
     * @param token
     * @param key)
     * @return
     */
    public static String validateJWToken(String token, String key) {
        try {
            Map<String, Object> map = Jwts.parser()
                    .setSigningKey(KEY)
                    .parseClaimsJws(token)
                    .getBody();
            return String.valueOf(map.get(key));
        } catch (Exception e) {
            throw new IllegalStateException("Invalid Token. " + e.getMessage());
        }
    }

    /**
     * 获取指定header头中的内容
     *
     * @param header
     * @return
     */
    public static String getRequestHeader(String header) {
        ServletRequestAttributes res = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = res.getRequest();
        String accessToken = request.getHeader(header);
        return accessToken;
    }

    /**
     * 获取uuid
     *
     * @return
     */
    public static String getJWTokenUuid() {
        return JWTokenUtil.validateJWToken(JWTokenUtil.getRequestHeader("X-Access-Token"), "uuid");
    }
}
