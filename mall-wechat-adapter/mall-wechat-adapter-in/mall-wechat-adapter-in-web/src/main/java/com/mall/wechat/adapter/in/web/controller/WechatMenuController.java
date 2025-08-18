package com.mall.wechat.adapter.in.web.controller;

import com.mall.wechat.application.command.CreateWechatMenuCommand;
import com.mall.wechat.application.command.UpdateWechatMenuCommand;
import com.mall.wechat.application.dto.WechatMenuResponse;
import com.mall.wechat.application.port.in.WechatMenuUseCase;
import com.mall.wechat.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 微信菜单控制器
 */
@Tag(name = "微信菜单管理", description = "微信菜单相关接口")
@RestController
@RequestMapping("/api/wechat/menus")
@RequiredArgsConstructor
public class WechatMenuController {
    
    private final WechatMenuUseCase wechatMenuUseCase;
    
    @Operation(summary = "创建微信菜单", description = "创建新的微信菜单")
    @PostMapping
    public Result<WechatMenuResponse> createWechatMenu(@Valid @RequestBody CreateWechatMenuCommand command) {
        WechatMenuResponse response = wechatMenuUseCase.createWechatMenu(command);
        return Result.success(response);
    }
    
    @Operation(summary = "更新微信菜单", description = "更新微信菜单信息")
    @PutMapping("/{menuId}")
    public Result<WechatMenuResponse> updateWechatMenu(
            @Parameter(description = "菜单ID") @PathVariable Long menuId,
            @Valid @RequestBody UpdateWechatMenuCommand command) {
        WechatMenuResponse response = wechatMenuUseCase.updateWechatMenu(menuId, command);
        return Result.success(response);
    }
    
    @Operation(summary = "根据ID查询微信菜单", description = "根据菜单ID查询微信菜单详情")
    @GetMapping("/{menuId}")
    public Result<WechatMenuResponse> getWechatMenuById(
            @Parameter(description = "菜单ID") @PathVariable Long menuId) {
        WechatMenuResponse response = wechatMenuUseCase.getWechatMenuById(menuId);
        return Result.success(response);
    }
    
    @Operation(summary = "查询所有微信菜单", description = "查询所有微信菜单列表")
    @GetMapping
    public Result<List<WechatMenuResponse>> getAllWechatMenus() {
        List<WechatMenuResponse> responses = wechatMenuUseCase.getAllWechatMenus();
        return Result.success(responses);
    }
    
    @Operation(summary = "根据父菜单ID查询子菜单", description = "根据父菜单ID查询子菜单列表")
    @GetMapping("/parent/{parentId}")
    public Result<List<WechatMenuResponse>> getWechatMenusByParentId(
            @Parameter(description = "父菜单ID") @PathVariable Integer parentId) {
        List<WechatMenuResponse> responses = wechatMenuUseCase.getWechatMenusByParentId(parentId);
        return Result.success(responses);
    }
    
    @Operation(summary = "根据菜单状态查询菜单", description = "根据菜单状态查询菜单列表")
    @GetMapping("/state/{menuState}")
    public Result<List<WechatMenuResponse>> getWechatMenusByState(
            @Parameter(description = "菜单状态") @PathVariable Integer menuState) {
        List<WechatMenuResponse> responses = wechatMenuUseCase.getWechatMenusByState(menuState);
        return Result.success(responses);
    }
    
    @Operation(summary = "删除微信菜单", description = "根据菜单ID删除微信菜单")
    @DeleteMapping("/{menuId}")
    public Result<Void> deleteWechatMenu(
            @Parameter(description = "菜单ID") @PathVariable Long menuId) {
        wechatMenuUseCase.deleteWechatMenu(menuId);
        return Result.success();
    }
}