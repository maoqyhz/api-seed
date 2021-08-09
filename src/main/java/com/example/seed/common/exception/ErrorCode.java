package com.example.seed.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mqy6289
 * @date 2021/7/12-15:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorCode {
    private int code;
    private String msg;
}