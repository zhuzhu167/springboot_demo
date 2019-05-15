package cn.ykthink.jewelry.core.support.http;

import okhttp3.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Author: YK
 * Title: AbstractHttpSupport
 * Description: AbstractHttpSupport
 * Date: 2018/12/23
 * Time: 17:25
 */
public abstract class AbstractHttpSupport {

    public static OkHttpClient obtainOkHttpClient() {
        return new OkHttpClient();
    }

    protected static String obtainResult(Request request) {

        OkHttpClient okHttpClient = obtainOkHttpClient();
        String result = null;

        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                int code = response.code();
                if (code == HttpStatus.OK.value()) {
                    ResponseBody responeseBody = response.body();
                    result = responeseBody.string();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    protected static HttpUrl obtainHttpUrl(String encode, Map<String, String> paramsMap) {

        HttpUrl.Builder httpBuilder = new HttpUrl.Builder();
        HttpUrl httpUrl = null;
        if (paramsMap != null) {

            Set<Map.Entry<String, String>> paramsEntrySet = paramsMap.entrySet();
            for (Map.Entry<String, String> entry : paramsEntrySet) {
                httpBuilder.addEncodedQueryParameter(entry.getValue(), encode);
            }

            httpUrl = httpBuilder.build();
        }
        return httpUrl;
    }

    protected static Headers obtainHeaders(Map<String, String> headersMap) {
        Headers.Builder builder = new Headers.Builder();
        Headers headers = null;
        if (headersMap != null) {
            Set<Map.Entry<String, String>> entrySet = headersMap.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                builder.add(entry.getKey(), entry.getValue());
            }
            headers = builder.build();
        }
        return headers;
    }


    protected static FormBody obtainForms(Map<String, String> fromsMap) {
        FormBody.Builder formBodyByulder = new FormBody.Builder();
        FormBody formBody = null;
        if (fromsMap != null) {
            Set<Map.Entry<String, String>> entrySet = fromsMap.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                formBodyByulder.add(entry.getKey(), entry.getValue());
            }
            formBody = formBodyByulder.build();
        }
        return formBody;
    }

    /**
     * Creates {@link CloseableHttpClient} instance with default
     * configuration.
     */
    protected static CloseableHttpClient createDefault() {
        return HttpClientBuilder.create().build();
    }

    /**
     * http 拦截
     *
     * @param request   请求
     * @param response  响应
     * @param joinPoint 信息
     * @throws Exception 异常
     */
    public static void intercept(HttpServletRequest request, HttpServletResponse response, ProceedingJoinPoint joinPoint) throws Exception {
        //构建一个 springMVC 拦截器
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
