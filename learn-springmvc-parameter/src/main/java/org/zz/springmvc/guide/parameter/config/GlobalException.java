package org.zz.springmvc.guide.parameter.config;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalException {
    // 处理NoHandlerFoundException异常，通常发生在请求的URL没有相应的映射处理方法时
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleNoHandlerFoundException() {
        return "No handler found for the request.";
    }

    // 未知异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, ?> handler(Exception e) {
        Map<String, Object> map = Map.of("msg", e.getMessage());
        return map;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Map<String, ?> handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        assert fieldError != null;
        Map<String, Object> map = Map.of("msg", Objects.requireNonNull(fieldError.getDefaultMessage()));
        return map;
    }

   // 参数绑定到对象上异常
   // 1. 参数格式错误
   // 2. 参数校验失败
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Map<String, ?> handler(BindException e) {

        FieldError fieldError = e.getFieldError();
        String msg = "";
        if (fieldError != null && fieldError.isBindingFailure()) {
            msg = "输入参数错误格式错误";
        } else {
            msg = e.getFieldError().getDefaultMessage();
        }

        Map<String, Object> map = Map.of("msg", msg);
        return map;
    }


    @ExceptionHandler(HandlerMethodValidationException.class)
    @ResponseBody
    public Map<String, ?> handler(HandlerMethodValidationException e) {
        Object[] detailMessageArguments = e.getDetailMessageArguments();
        String msg = detailMessageArguments[0].toString();

        Map<String, Object> map = Map.of("msg", msg);
        return map;
    }

    // 字段类型错误
    // form请求中, 输入参数类型与接收参数类型不匹配
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Map<String, ?> handler(MethodArgumentTypeMismatchException e) {

        String msg = "输入参数字段:[" + e.getName() + "]类型错误";
        Map<String, Object> map = Map.of("msg", msg);
        return map;
    }
}
