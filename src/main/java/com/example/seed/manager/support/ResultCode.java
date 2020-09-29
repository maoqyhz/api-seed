package com.example.seed.manager.support;

import lombok.Getter;

import java.util.Optional;

/**
 * 错误代码定义
 *
 * @author Fururur
 * @create 2019-07-23-10:24
 */
@Getter
public enum ResultCode {
    SUCCESS(0, "Success"),
    REQUEST_FAILED_ERROR(-5001, "后台请求返回失败"),
    INVALID_PARAMS_ERROR(-5002, "请求参数不合法"),
    NO_OBJECT_IN_DATABASE(-5003, "修改的对象不存在"),
    NO_EXIST_USER_ERROR(-5004, "用户不存在"),
    INVALID_USER_CREDENTIALS_ERROR(-5005, "用户名或密码错误");


    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Optional<ResultCode> getByCode(int code) {
        for (ResultCode ec : ResultCode.values()) {
            if (ec.getCode() == code) {
                return Optional.of(ec);
            }
        }
        return Optional.empty();
    }

    public static String toMsg(int code) {
        Optional<ResultCode> rc = getByCode(code);
        return rc.map(ResultCode::getMsg).orElse(null);
    }
}
