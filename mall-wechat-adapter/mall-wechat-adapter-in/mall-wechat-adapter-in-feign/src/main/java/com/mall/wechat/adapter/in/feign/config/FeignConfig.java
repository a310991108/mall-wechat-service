package com.mall.wechat.adapter.in.feign.config;

import feign.RequestInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            // 1. 获取当前请求的所有头信息
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                Enumeration<String> headerNames = request.getHeaderNames();

                // 2. 遍历并添加所有请求头到Feign请求
                while (headerNames.hasMoreElements()) {
                    String headerName = headerNames.nextElement();

                    // 跳过不需要传递的敏感头（可选）
                    if (shouldSkipHeader(headerName)) continue;

                    Enumeration<String> values = request.getHeaders(headerName);
                    while (values.hasMoreElements()) {
                        String value = values.nextElement();
                        template.header(headerName, value);
                    }
                }
            }
//
//            // 3. 补充固定请求头
//            template.header("X-Client", "FeignDemo");
//
//            // 4. 补充动态请求头（示例）
//            template.header("X-Request-Timestamp", String.valueOf(System.currentTimeMillis()));
        };
    }

    // 可选：过滤不需要传递的请求头
    private boolean shouldSkipHeader(String headerName) {
        // 这些头由Feign/HTTP客户端自动处理，不应手动传递
        Set<String> skipHeaders = new HashSet<>(Arrays.asList(
                "content-length", "content-type", "host", "connection",
                "accept-encoding", "user-agent"
        ));
        return skipHeaders.contains(headerName.toLowerCase());
    }

}