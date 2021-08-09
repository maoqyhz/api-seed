package com.example.seed.common.exception;

/**
 * 错误代码定义
 * 0 - success
 * -4xxx - 无权限操作
 * -5xxx - 通用的服务器异常
 * <p>
 * -5Mxxx - 模块异常错误 M为模块编号
 * -51xxx - dms
 * -52xxx - meeting
 * -53xxx - model zoo
 * -54xxx - ops
 *
 * @author mqy6289
 * @date 2019-07-23-10:24
 */
public interface BaseResultCode {
    ErrorCode SUCCESS = new ErrorCode(0, "Success");
    ErrorCode UNAUTHORIZED_ACCESS_ERROR = new ErrorCode(-4001, "无访问权限");
    ErrorCode NO_AUTH_TO_OPERATE = new ErrorCode(-4002, "当前用户无权限进行此操作");

    ErrorCode REQUEST_FAILED_ERROR = new ErrorCode(-5001, "请求失败");
    ErrorCode INVALID_PARAMS_ERROR = new ErrorCode(-5002, "请求参数不合法");
    ErrorCode NULL_OBJECT = new ErrorCode(-5003, "操作对象为Null");
    ErrorCode SSH_UNKNOWN_ERROR = new ErrorCode(-5004, "SSH执行未知异常");
    ErrorCode SSH_EXEC_ERROR = new ErrorCode(-5005, "SSH命令执行错误");
    ErrorCode FILE_TOO_LARGE = new ErrorCode(-5006, "附件大小过大");
    ErrorCode FEIGN_REQUEST_ERROR = new ErrorCode(-5007, "Feign 请求失败");
}
