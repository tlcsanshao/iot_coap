package org.example.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.io.Serializable;

/**
 * author: sunam
 * date: 2025/3/7
 * ApiResult desc:
 */
@Getter
public class ApiResult<T> implements Serializable {
    public static final String OK_MSG = "成功";
    public static final String FAIL_MSG = "失败";
    public static final String INVALID_PARAMETER_MSG = "请求参数不合法: ";
    public static final int OK_CODE = 200;
    public static final int FAIL_CODE = 40004;
    public static final int RETURN_CODE = 40005;
    public static final String RETCODE_CLIENT = "client";
    public static final String RETCODE_UNKNOWN_ERROR = "error.unknown";
    public static final String RETCODE_INVALID_ERROR = "error.invalid";
    public static final ApiResult<String> SERVER_UNAVAILABLE = fail("服务不可访问");
    private int code;
    private String retcode;
    private String message;
    private T body;
    public static final ApiResult<String> OK = success();
    public static final ApiResult<String> FAIL = fail();

    protected ApiResult(int code, String retcode, String message) {
        this(code, retcode, message, null);
    }

    protected ApiResult(int code, String retcode, String message, T body) {
        this.code = code;
        this.retcode = retcode;
        this.message = message;
        this.body = body;
    }

    public static <T> ApiResult<T> ok(T data) {
        return ok("成功", data);
    }

    public static <T> ApiResult<T> ok(String message, T data) {
        return new ApiResult<>(200, (String)null, message, data);
    }

    public static <T> ApiResult<T> success() {
        return success("成功");
    }

    public static <T> ApiResult<T> success(String message) {
        return new ApiResult<>(200, null, message, null);
    }

    public static <T> ApiResult<T> fail(String message) {
        return new ApiResult<>(40004, "client", message);
    }

    public static <T> ApiResult<T> fail() {
        return fail("失败");
    }

    public static <T> ApiResult<T> invalid(String paramName) {
        return new ApiResult<>(40004, "error.invalid", "请求参数不合法: " + paramName);
    }

    public static <T> ApiResult<T> error(int code, String retcode, String message) {
        return new ApiResult<>(code, retcode, message);
    }

    public static <T> ApiResult<T> error(String retcode, String message) {
        return new ApiResult<>(40004, retcode, message);
    }

    public static <T> ApiResult<T> error(String message) {
        return new ApiResult<>(40004, "error.unknown", message);
    }

    @JsonIgnore
    public Boolean isSuccess() {
        return this.code == 200;
    }

    protected void setCode(int code) {
        this.code = code;
    }

    protected void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    protected void setMessage(String message) {
        this.message = message;
    }

    protected void setBody(T body) {
        this.body = body;
    }

    protected ApiResult() {
    }
}

