package cn.ykthink.jewelry.core.support.http;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: YK
 * Title: AbstractHttpSupport
 * Description: AbstractHttpSupport
 * Date: 2018/12/23
 * Time: 17:25
 */
public abstract class AbstractHttpSupport {


    /**
     * http 预处理
     *
     * @param request   请求
     * @param response  响应
     * @param joinPoint 信息
     * @throws Exception 异常
     */
    public static void intercept(HttpServletRequest request, HttpServletResponse response, ProceedingJoinPoint joinPoint) throws Exception {
        //构建一个预处理
        HandlerInterceptorAdapter handlerInterceptorAdapter = new HandlerInterceptorAdapter() {
            @Override
            //预处理，返回false时不会下传，往回传递，被拦截的方法不会执行
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                return false;
            }
        };
        handlerInterceptorAdapter.preHandle(request, response, joinPoint);
    }
}
