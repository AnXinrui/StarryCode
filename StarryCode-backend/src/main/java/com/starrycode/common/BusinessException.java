package com.starrycode.common;

import lombok.Data;
import lombok.Getter;

/**
 * 自定义异常类
 * @author axr
 */
@Getter
public class BusinessException extends RuntimeException {
    private final int code;     // 错误码
    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }
}
