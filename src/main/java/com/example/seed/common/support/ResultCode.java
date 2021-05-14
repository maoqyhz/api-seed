package com.example.seed.common.support;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误代码定义
 *
 * @author Fururur
 * @create 2019-07-23-10:24
 */
@AllArgsConstructor
@Getter
public enum ResultCode {
    SUCCESS(0, "success"),
    REQUEST_FAILED_ERROR(-5001, "后台请求返回失败"),
    INVALID_PARAMS_ERROR(-5002, "请求参数不合法"),
    OBJECT_NOT_FOUND(-5003, "对象不存在"),
    OBJECT_REPEATED(-5004, "对象重复");

    private final int code;
    private final String msg;
}
