package com.example.seed.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.seed.common.support.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * @author Fururur
 * @create 2019-12-12-10:14
 */
@Slf4j
@Controller
public class ApiController {

    /**
     * parse前端json字符串
     *
     * @param request
     * @return
     */
    protected JSONObject parserJson(HttpServletRequest request) {
        StringBuffer buffer = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return JSONObject.parseObject(buffer.toString());
    }

    @GetMapping("/query")
    public CommonResult<String> query() {
        return CommonResult.ok("hello");
    }
}
