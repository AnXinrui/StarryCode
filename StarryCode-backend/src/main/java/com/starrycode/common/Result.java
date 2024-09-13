package com.starrycode.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 * @author axr
 */
@Data
public class Result<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public Result(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
