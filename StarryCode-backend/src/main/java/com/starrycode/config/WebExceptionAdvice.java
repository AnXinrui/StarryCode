package com.starrycode.config;

import com.starrycode.common.BusinessException;
import com.starrycode.common.Result;
import com.starrycode.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 全局异常处理器
 @author axr
 */
@Slf4j
@RestControllerAdvice
public class WebExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public Result<?> businessExceptionHandler(BusinessException e) {
        // log.error("BusinessException", e);
        return ResultUtils.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<?> handleRuntimeException(RuntimeException e) {
        log.error(e.toString(), e);
        return ResultUtils.fail("服务器异常");
    }
}