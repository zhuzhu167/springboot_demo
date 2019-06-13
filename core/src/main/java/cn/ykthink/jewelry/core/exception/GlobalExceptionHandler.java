package cn.ykthink.jewelry.core.exception;


import cn.ykthink.jewelry.core.constant.HttpResponseConstant;
import cn.ykthink.jewelry.core.exception.cmsException.storeException;
import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
import lombok.extern.log4j.Log4j2;
import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: YK
 * Title: GlobalExceptionHandler
 * Description: 全局异常捕捉
 * Date: 2019/5/18
 * Time: 9:54
 */
@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常
     *
     * @param throwable
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseEntity<Object> handleException(Throwable throwable) {
        log.error("异常报告", throwable);
        return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, HttpResponseConstant.HTTP_MESSAGE_INTERNAL_SERVER_ERROR, "网络繁忙");
    }

    /**
     * 格式转换异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ParseException.class)
    @ResponseBody
    public ResponseEntity<Object> handleParseException(ParseException e) {
        log.error("格式转换异常：", e);
        return ResponseEntitySupport.error(HttpStatus.INTERNAL_SERVER_ERROR, HttpResponseConstant.HTTP_MESSAGE_INTERNAL_SERVER_ERROR, "网络繁忙");
    }

    /**
     * 库存不足异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(storeException.class)
    @ResponseBody
    public ResponseEntity<Object> handleStoreException(storeException  e) {
        log.error("库存不足异常：", e);
        return ResponseEntitySupport.error(HttpStatus.FORBIDDEN, e.getMessage()+"库存不足", e.getMessage()+"Inventory shortage");
    }

    /**
     * 校验异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, String> reasonMap = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            reasonMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        JSONObject errorJSON = new JSONObject();
        errorJSON.put("reason", reasonMap);
        return ResponseEntitySupport.error(HttpStatus.BAD_REQUEST, HttpResponseConstant.HTTP_MESSAGE_BAG_REQUEST, errorJSON.get("reason"));
    }
}
