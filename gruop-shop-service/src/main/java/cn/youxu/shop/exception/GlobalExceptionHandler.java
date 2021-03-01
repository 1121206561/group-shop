package cn.youxu.shop.exception;

import cn.youxu.shop.common.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 未捕获全局异常处理
     */
    @ExceptionHandler(Exception.class)
    public CommonResponse handleException(Exception e) {
        System.out.println(e);
        return CommonResponse.error().message("未知异常请联系管理员");
    }

}