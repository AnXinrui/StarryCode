package com.starrycode.common;

import java.io.Serializable;

/**
 * 返回工具类
 */
public class ResultUtils implements Serializable {
    public static <T> Result<T> success() {
        return new Result<>(0, null, "success!");
    }
    public static <T> Result<T> success(T data) {
        return new Result<T>(0, data, "success!");
    }
    public static <T> Result<T> success(T data, String message) {
        return new Result<>(0, data, message);
    }
    public static <T> Result<T> success(String message) {
        return new Result<>(0, null, message);
    }

    public static <T> Result<T> fail() {
        return new Result<>(0, null, "fail!");
    }
    public static <T> Result<T> fail(String message) {
        return new Result<>(-1, null, message);
    }
    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, null, message);
    }
}
