package cn.ykthink.jewelry.core.config.mysql;

/**
 * Author: YK
 * Title: DruidStatViewServlet
 * Description: 连接池
 * Date: 2018/12/24
 * Time: 18:22
 */

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(
        urlPatterns = {"/druid/*"},
        initParams = {
//                @WebInitParam(name="allow",value="192.168.1.113,127.0.0.1"),// IP白名单 (没有配置或者为空，则允许所有访问)
//                @WebInitParam(name="deny",value="127.0.0.1"),// IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name = "loginUsername", value = "admin"),// 用户名
                @WebInitParam(name = "loginPassword", value = "fyk159753"),// 密码
                @WebInitParam(name = "resetEnable", value = "false")// 允许HTML页面上的“Reset All”功能

        }
)
public class DruidStatViewServlet extends StatViewServlet implements Servlet {
    private static final long serialVersionUID = 1L;
}
