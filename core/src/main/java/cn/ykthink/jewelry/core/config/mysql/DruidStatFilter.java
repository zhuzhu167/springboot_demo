package cn.ykthink.jewelry.core.config.mysql;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Author: YK
 * Title: DruidStatFilter
 * Description: 连接池StatFilter
 * Date: 2018/12/24
 * Time: 18:21
 */
@WebFilter(
        filterName = "druidWebStatFilter",
        urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "exclusions", value = "*.js,*.jpg,*.png,*.gif,*.ico,*.css,/druid/*")//配置本过滤器放行的请求后缀
        }
)
public class DruidStatFilter extends WebStatFilter {
}
