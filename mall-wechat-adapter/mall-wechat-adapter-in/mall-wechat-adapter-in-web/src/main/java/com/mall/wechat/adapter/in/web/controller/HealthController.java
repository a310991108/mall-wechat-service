package com.mall.wechat.adapter.in.web.controller;

import com.mall.wechat.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 健康检查控制器
 */
@Tag(name = "健康检查", description = "服务健康检查接口")
@RestController
@RequestMapping("/api/health")
public class HealthController {
    
    @Operation(summary = "健康检查", description = "检查服务是否正常运行")
    @GetMapping
    public Result<Map<String, Object>> health() {
        Map<String, Object> healthInfo = new HashMap<>();
        healthInfo.put("status", "UP");
        healthInfo.put("service", "mall-wechat-service");
        healthInfo.put("timestamp", LocalDateTime.now());
        healthInfo.put("version", "1.0.0");
        
        return Result.success(healthInfo);
    }
}