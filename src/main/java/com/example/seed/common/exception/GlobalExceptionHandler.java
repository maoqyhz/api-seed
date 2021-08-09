package com.example.seed.common.exception;

import com.example.seed.common.support.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理
 *
 * @author Fururur
 * @create 2020-01-02-11:02
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public <T> CommonResult<T> serviceExceptionHandler(ServiceException ex) {
        log.error(ex.toString(), ex);
        return CommonResult.bizError(ex.getCode(), ex.getMsg());
    }

    /**
     * 处理一般500异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public CommonResult<String> runtimeExceptionHandler(RuntimeException ex) {
        log.error(ex.toString(), ex);
        CommonResult<String> result = new CommonResult<>();
        result.setCode(500);
        result.setMsg("服务器异常，请联系管理员");
        result.setData(ex.toString());
        return result;
    }

    /**
     * 处理404异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonResult<String> noHandlerFoundExceptionHandler(Exception ex) {
        CommonResult<String> result = new CommonResult<>();
        result.setCode(404);
        result.setMsg("访问资源不存在或参数错误");
        result.setData(ex.toString());
        return result;
    }

    /**
     * 处理405异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult<String> httpRequestMethodNotSupportedExceptionHandler(Exception ex) {
        CommonResult<String> result = new CommonResult<>();
        result.setCode(405);
        result.setMsg("HTTP请求方式错误");
        result.setData(ex.toString());
        return result;
    }
}
