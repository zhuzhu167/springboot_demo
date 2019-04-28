package cn.ykthink.jewelry.core.exception;


import cn.ykthink.jewelry.core.constant.HttpResponseConstant;
import cn.ykthink.jewelry.core.support.http.ResponseEntitySupport;
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


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: YK
 * Title: ValidatorExceptionHandler
 * Description: 校验异常处理
 * Date: 2019/4/9
 * Time: 19:19
 */

@ControllerAdvice
public class ValidatorExceptionHandler {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
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
