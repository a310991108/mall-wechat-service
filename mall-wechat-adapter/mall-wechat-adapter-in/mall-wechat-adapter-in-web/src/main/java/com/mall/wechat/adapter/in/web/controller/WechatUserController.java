package com.mall.wechat.adapter.in.web.controller;

import com.mall.wechat.application.port.in.WechatUserUseCase;
import com.mall.wechat.application.port.in.command.CreateWechatUserCommand;
import com.mall.wechat.application.port.in.command.UpdateWechatUserCommand;
import com.mall.wechat.application.port.in.response.WechatUserResponse;
import com.mall.wechat.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 微信用户控制器
 */
@Tag(name = "微信用户管理", description = "微信用户相关接口")
@RestController
@RequestMapping("/api/wechat/users")
@RequiredArgsConstructor
public class WechatUserController {
    
    private final WechatUserUseCase wechatUserUseCase;
    
    @Operation(summary = "创建微信用户", description = "创建新的微信用户")
    @PostMapping
    public Result<WechatUserResponse> createWechatUser(@Valid @RequestBody CreateWechatUserCommand command) {
        WechatUserResponse response = wechatUserUseCase.createWechatUser(command);
        return Result.success(response);
    }
    
    @Operation(summary = "更新微信用户", description = "更新微信用户信息")
    @PutMapping("/{userId}")
    public Result<WechatUserResponse> updateWechatUser(
            @Parameter(description = "用户ID") @PathVariable Long userId,
            @Valid @RequestBody UpdateWechatUserCommand command) {
        WechatUserResponse response = wechatUserUseCase.updateWechatUser(userId, command);
        return Result.success(response);
    }
    
    @Operation(summary = "根据ID查询微信用户", description = "根据用户ID查询微信用户详情")
    @GetMapping("/{userId}")
    public Result<WechatUserResponse> getWechatUserById(
            @Parameter(description = "用户ID") @PathVariable Long userId) {
        WechatUserResponse response = wechatUserUseCase.getWechatUserById(userId);
        return Result.success(response);
    }
    
    @Operation(summary = "根据OpenID查询微信用户", description = "根据微信OpenID查询用户详情")
    @GetMapping("/openid/{openId}")
    public Result<WechatUserResponse> getWechatUserByOpenId(
            @Parameter(description = "微信OpenID") @PathVariable String openId) {
        WechatUserResponse response = wechatUserUseCase.getWechatUserByOpenId(openId);
        return Result.success(response);
    }
    
    @Operation(summary = "查询所有微信用户", description = "查询所有微信用户列表")
    @GetMapping
    public Result<List<WechatUserResponse>> getAllWechatUsers() {
        List<WechatUserResponse> responses = wechatUserUseCase.getAllWechatUsers();
        return Result.success(responses);
    }
    
    @Operation(summary = "根据标签查询微信用户", description = "根据微信标签ID查询用户列表")
    @GetMapping("/tag/{wechatTagId}")
    public Result<List<WechatUserResponse>> getWechatUsersByTagId(
            @Parameter(description = "微信标签ID") @PathVariable String wechatTagId) {
        List<WechatUserResponse> responses = wechatUserUseCase.getWechatUsersByTagId(wechatTagId);
        return Result.success(responses);
    }
    
    @Operation(summary = "删除微信用户", description = "根据用户ID删除微信用户")
    @DeleteMapping("/{userId}")
    public Result<Void> deleteWechatUser(
            @Parameter(description = "用户ID") @PathVariable Long userId) {
        wechatUserUseCase.deleteWechatUser(userId);
        return Result.success();
    }
}