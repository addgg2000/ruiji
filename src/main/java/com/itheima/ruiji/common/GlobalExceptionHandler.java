package com.itheima.ruiji.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalExceptionHandler {
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public R<String> SQLIntegrityConstraintViolationException(Exception ex){
        ex.printStackTrace();
        String[] message = ex.getCause().getMessage().split(" ");
        String key = message[2];
        return R.error(key + "已经存在！");
    }
    @ExceptionHandler(value = Exception.class)
    public R<String> exceptionHandler(Exception ex){
        ex.printStackTrace();
        return R.error(ex.getMessage());
    }
}
