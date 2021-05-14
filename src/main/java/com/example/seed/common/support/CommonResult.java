package com.example.seed.common.support;

import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.Data;
import org.springframework.validation.BindingResult;

import java.io.Serializable;

/**
 * @author Fururur
 * @date 2019-07-23-10:19
 */
@Data
public class CommonResult<T> implements Serializable {
    private Integer code = ResultCode.SUCCESS.getCode();
    private String msg = ResultCode.SUCCESS.getMsg();
    private T data;

    public static <T> CommonResult<T> ok() {
        return new CommonResult<>();
    }

    public static <T> CommonResult<T> ok(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setData(data);
        return result;
    }

    public static <T> CommonResult<T> bizError(ResultCode code) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }

    public static <T> CommonResult<T> bizError(ResultCode code, String msg) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(code.getCode());
        result.setMsg(msg);
        return result;
    }

    public static CommonResult<Multimap<String, String>> invalidParams(BindingResult bindingResult) {
        Multimap<String, String> errors = ArrayListMultimap.create();
        bindingResult.getFieldErrors().forEach(e -> errors.put("errors", e.getDefaultMessage()));
        return invalidParams(errors);
    }

    public static CommonResult<Multimap<String, String>> invalidParams(Multimap<String, String> errors) {
        CommonResult<Multimap<String, String>> result = new CommonResult<>();
        result.setCode(ResultCode.INVALID_PARAMS_ERROR.getCode());
        result.setMsg(Joiner.on(",").join(errors.get("errors").toArray()));
        result.setData(errors);
        return result;
    }

    public static <T> CommonResult<T> invalidParams() {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(ResultCode.INVALID_PARAMS_ERROR.getCode());
        result.setMsg(ResultCode.INVALID_PARAMS_ERROR.getMsg());
        return result;
    }

    public static <T> CommonResult<T> invalidParams(String msg) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(ResultCode.INVALID_PARAMS_ERROR.getCode());
        result.setMsg(msg);
        return result;
    }
}
