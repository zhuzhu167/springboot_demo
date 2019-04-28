package cn.ykthink.jewelry.core.constant;

/**
 * Author: YK
 * Title: HttpResponseConstant
 * Description:
 * Date: 2019/3/2
 * Time: 17:55
 */
public final class HttpResponseConstant {
    private HttpResponseConstant() {
    }

    public static final String HTTP_MESSAGE_BAG_REQUEST = "请求体不完整";
    public static final String HTTP_MESSAGE_NOT_FOUND = "资源不存在";
    public static final String HTTP_MESSAGE_FORBIDDEN = "请勿重复请求";
    public static final String HTTP_MESSAGE_CONFLICT = "请求资源冲突";
    public static final String HTTP_MESSAGE_PRECONDITION_FAILED = "请求头有误";
    public static final String HTTP_MESSAGE_UNAUTHORIZED = "token鉴权失败";
    public static final String HTTP_MESSAGE_INTERNAL_SERVER_ERROR = "网络繁忙，请稍后再试";
}
