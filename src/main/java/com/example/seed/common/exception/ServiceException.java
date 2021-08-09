package com.example.seed.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Fururur
 * @date 2020-01-03-10:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {
    private ErrorCode code;
    private String msg;

    public ServiceException(ErrorCode code) {
        super(code.getMsg());
        this.code = code;
        this.msg = code.getMsg();
    }

    public ServiceException(ErrorCode code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}