package com.mall.wechat.adapter.in.web.controller;

import com.mall.wechat.application.command.CreateWechatUserCommand;
import com.mall.wechat.application.command.UpdateWechatUserCommand;
import com.mall.wechat.application.dto.WechatUserResponse;
import com.mall.wechat.application.port.in.*;
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
    private final WechatUserCreateUseCase wechatUserCreateUseCase;
    private final WechatUserUpdateUseCase wechatUserUpdateUseCase;
    private final WechatUserDeleteUseCase wechatUserDeleteUseCase;
    private final WechatUserGetAllUseCase wechatUserGetAllUseCase;
    private final WechatUserGetByIdUseCase wechatUserGetByIdUseCase;
    private final WechatUserGetByOpenIdUseCase wechatUserGetByOpenIdUseCase;
    private final WechatUserGetByTagIdUseCase wechatUserGetByTagIdUseCase;


    @Operation(summary = "创建微信用户", description = "创建新的微信用户")
    @PostMapping
    public Result<WechatUserResponse> createWechatUser(@Valid @RequestBody CreateWechatUserCommand command) {
        WechatUserResponse response = wechatUserCreateUseCase.createWechatUser(command);
        return Result.success(response);
    }
    
    @Operation(summary = "更新微信用户", description = "更新微信用户信息")
    @PutMapping("/{userId}")
    public Result<WechatUserResponse> updateWechatUser(
            @Parameter(description = "用户ID") @PathVariable Long userId,
            @Valid @RequestBody UpdateWechatUserCommand command) {
        WechatUserResponse response = wechatUserUpdateUseCase.updateWechatUser(userId, command);
        return Result.success(response);
    }
    
    @Operation(summary = "根据ID查询微信用户", description = "根据用户ID查询微信用户详情")
    @GetMapping("/{userId}")
    public Result<WechatUserResponse> getWechatUserById(
            @Parameter(description = "用户ID") @PathVariable Long userId) {
        WechatUserResponse response = wechatUserGetByIdUseCase.getWechatUserById(userId);
        return Result.success(response);
    }
    
    @Operation(summary = "根据OpenID查询微信用户", description = "根据微信OpenID查询用户详情")
    @GetMapping("/openid/{openId}")
    public Result<WechatUserResponse> getWechatUserByOpenId(
            @Parameter(description = "微信OpenID") @PathVariable String openId) {
        WechatUserResponse response = wechatUserGetByOpenIdUseCase.getWechatUserByOpenId(openId);
        return Result.success(response);
    }
    
    @Operation(summary = "查询所有微信用户", description = "查询所有微信用户列表")
    @GetMapping
    public Result<List<WechatUserResponse>> getAllWechatUsers() {
        List<WechatUserResponse> responses = wechatUserGetAllUseCase.getAllWechatUsers();
        return Result.success(responses);
    }
    
    @Operation(summary = "根据标签查询微信用户", description = "根据微信标签ID查询用户列表")
    @GetMapping("/tag/{wechatTagId}")
    public Result<List<WechatUserResponse>> getWechatUsersByTagId(
            @Parameter(description = "微信标签ID") @PathVariable String wechatTagId) {
        List<WechatUserResponse> responses = wechatUserGetByTagIdUseCase.getWechatUsersByTagId(wechatTagId);
        return Result.success(responses);
    }
    
    @Operation(summary = "删除微信用户", description = "根据用户ID删除微信用户")
    @DeleteMapping("/{userId}")
    public Result<Void> deleteWechatUser(
            @Parameter(description = "用户ID") @PathVariable Long userId) {
        wechatUserDeleteUseCase.deleteWechatUser(userId);
        return Result.success();
    }
}