package com.example.seed.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * @author Fururur
 * @create 2019-12-12-10:14
 */
@Slf4j
@RestController
@RequestMapping("api")
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
    public String query() {
        return "api";
    }
}
