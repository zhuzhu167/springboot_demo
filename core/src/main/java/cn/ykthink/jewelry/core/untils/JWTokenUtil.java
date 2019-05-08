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
     * 生成JWT
     *
     * @param uuid 用户ID
     * @return
     */
    public static String generateToken(String uuid) {
        Map<String, Object> map = new HashMap<>();
        map.put("uuid", uuid);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000_000L))// 1000 hour
                .signWith(SignatureAlgorithm.HS512, KEY)
                .compact();
        return jwt; //jwt前面一般都会加Bearer
    }

    public static String pcgenerateToken(String uuid, Integer lastPlateSort) {
        Map<String, Object> map = new HashMap<>();
        map.put("uuid", uuid);
        map.put("lastPlateSort", lastPlateSort);
        String jwt = Jwts.builder()
                .setClaims(map)
                .setExpiration(new Date(System.currentTimeMillis() + 3600_000_000L))// 1000 hour
                .signWith(SignatureAlgorithm.HS512, KEY)
                .compact();
        return jwt; //jwt前面一般都会加Bearer
    }

    /**
     * 校验JWT
     *
     * @param token
     * @return
     */
    public static String validateToken(String token) {
        try {
            Map<String, Object> map = Jwts.parser()
                    .setSigningKey(KEY)
                    .parseClaimsJws(token)
                    .getBody();
            return String.valueOf(map.get("uuid"));
        } catch (Exception e) {
            throw new IllegalStateException("Invalid Token. " + e.getMessage());
        }
    }

    /**
     * 获取用户uuid
     *
     * @return
     */
    public static String getUserUuid() {
        ServletRequestAttributes res = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = res.getRequest();
        String accessToken = request.getHeader("X-Access-Token");  //通过token 获取用户uuid
        return validateToken(accessToken);
    }


    public static void main(String[] args) {
//        System.out.println("-----------"+generateToken("100006")+"-----------");
        Date date = new Date();
        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        String bjDate = bjSdf.format(date);
        System.out.println("==============Asia/Tokyo============" + bjDate);

    }
}
