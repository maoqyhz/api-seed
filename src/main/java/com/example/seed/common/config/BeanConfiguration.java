package com.example.seed.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Qingyu Mao
 * @create 2019-07-26-15:46
 */
@Configuration("commonBeanConfiguration")
public class BeanConfiguration {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                // SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty
        );
        ValueFilter filter = (obj, s, v) -> {
            if (v == null) {
                return "";
            }
            if (v instanceof Double) {
                return String.format("%.2f", v);
            }
            return v;
        };
        fastJsonConfig.setSerializeFilters(filter);
        fastConverter.setFastJsonConfig(fastJsonConfig);
        List<MediaType> oFastMediaTypeList = new ArrayList<>();
        oFastMediaTypeList.add(MediaType.APPLICATION_JSON);
        fastConverter.setSupportedMediaTypes(oFastMediaTypeList);
        return new HttpMessageConverters(fastConverter);
    }

    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        // 连接池
        httpRequestFactory.setConnectionRequestTimeout(10000);
        // 连接服务器
        httpRequestFactory.setConnectTimeout(3000);
        // socket读取
        httpRequestFactory.setReadTimeout(10000);
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        for (int i = 0; i < messageConverters.size(); i++) {
            HttpMessageConverter<?> httpMessageConverter = messageConverters.get(i);
            if (httpMessageConverter.getClass().equals(StringHttpMessageConverter.class)) {
                messageConverters.set(i, new StringHttpMessageConverter(StandardCharsets.UTF_8));
            }
        }
        return restTemplate;
    }
}