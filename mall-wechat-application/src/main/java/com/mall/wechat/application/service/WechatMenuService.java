package com.mall.wechat.application.service;

import com.mall.wechat.application.command.CreateWechatMenuCommand;
import com.mall.wechat.application.command.UpdateWechatMenuCommand;
import com.mall.wechat.application.dto.WechatMenuResponse;
import com.mall.wechat.application.port.in.WechatMenuUseCase;
import com.mall.wechat.application.port.out.WechatMenuRepository;
import com.mall.wechat.common.exception.BusinessException;
import com.mall.wechat.common.enums.Resp;
import com.mall.wechat.domain.model.menu.WechatMenu;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 微信菜单应用服务
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WechatMenuService implements WechatMenuUseCase {
    
    private final WechatMenuRepository wechatMenuRepository;
    
    @Override
    @Transactional
    public WechatMenuResponse createWechatMenu(CreateWechatMenuCommand command) {
        log.info("创建微信菜单，菜单名称: {}", command.getMenuName());
        
        // 创建微信菜单
        WechatMenu wechatMenu = WechatMenu.create(
            command.getMenuName(),
            command.getMenuType(),
            command.getParentId(),
            command.getMenuSort()
        );
        
        // 设置父菜单名称
        if (command.getParentName() != null) {
            wechatMenu.setParentName(command.getParentName());
        }
        
        // 根据菜单类型设置相应属性
        if ("click".equals(command.getMenuType())) {
            wechatMenu.setClickMenu(
                command.getMenuKey(),
                command.getClickMsgType(),
                command.getMenuReplyData()
            );
        } else if ("view".equals(command.getMenuType())) {
            wechatMenu.setViewMenu(command.getMenuViewUrl());
        }
        
        // 保存微信菜单
        WechatMenu savedMenu = wechatMenuRepository.save(wechatMenu);
        
        log.info("微信菜单创建成功，菜单ID: {}", savedMenu.getMenuId());
        return convertToResponse(savedMenu);
    }
    
    @Override
    @Transactional
    public WechatMenuResponse updateWechatMenu(Long menuId, UpdateWechatMenuCommand command) {
        log.info("更新微信菜单，菜单ID: {}", command.getMenuId());
        
        WechatMenu wechatMenu = wechatMenuRepository.findById(command.getMenuId())
            .orElseThrow(() -> new BusinessException(Resp.WECHAT_MENU_NOT_FOUND));
        
        // 更新菜单基本信息
        if (command.getMenuName() != null) {
            wechatMenu.setMenuName(command.getMenuName());
        }
        
        if (command.getMenuSort() != null) {
            wechatMenu.setMenuSort(command.getMenuSort());
        }
        
        if (command.getMenuState() != null) {
            wechatMenu.setMenuState(command.getMenuState());
        }
        
        // 根据菜单类型更新相应属性
        if (command.getMenuType() != null) {
            wechatMenu.setMenuType(command.getMenuType());
            
            if ("click".equals(command.getMenuType())) {
                wechatMenu.setClickMenu(
                    command.getMenuKey(),
                    command.getClickMsgType(),
                    command.getMenuReplyData()
                );
            } else if ("view".equals(command.getMenuType())) {
                wechatMenu.setViewMenu(command.getMenuViewUrl());
            }
        }
        
        // 保存更新
        WechatMenu savedMenu = wechatMenuRepository.save(wechatMenu);
        
        log.info("微信菜单更新成功，菜单ID: {}", savedMenu.getMenuId());
        return convertToResponse(savedMenu);
    }
    
    @Override
    public WechatMenuResponse getWechatMenuById(Long menuId) {
        log.info("根据ID查询微信菜单: {}", menuId);
        
        WechatMenu wechatMenu = wechatMenuRepository.findById(menuId)
            .orElseThrow(() -> new BusinessException(Resp.WECHAT_MENU_NOT_FOUND));
        
        return convertToResponse(wechatMenu);
    }
    
    @Override
    public List<WechatMenuResponse> getAllWechatMenus() {
        log.info("查询所有微信菜单");
        
        List<WechatMenu> wechatMenus = wechatMenuRepository.findAll();
        return wechatMenus.stream()
            .map(this::convertToResponse)
            .collect(Collectors.toList());
    }
    
    @Override
    public List<WechatMenuResponse> getWechatMenusByParentId(Integer parentId) {
        log.info("根据父菜单ID查询子菜单: {}", parentId);
        
        List<WechatMenu> wechatMenus = wechatMenuRepository.findByParentId(parentId);
        return wechatMenus.stream()
            .map(this::convertToResponse)
            .collect(Collectors.toList());
    }
    
    @Override
    @Transactional
    public void deleteWechatMenu(Long menuId) {
        log.info("删除微信菜单，菜单ID: {}", menuId);
        
        if (!wechatMenuRepository.findById(menuId).isPresent()) {
            throw new BusinessException(Resp.WECHAT_MENU_NOT_FOUND);
        }
        
        wechatMenuRepository.deleteById(menuId);
        log.info("微信菜单删除成功，菜单ID: {}", menuId);
    }
    
    @Override
    @Transactional
    public void enableWechatMenu(Long menuId) {
        log.info("启用微信菜单，菜单ID: {}", menuId);
        
        WechatMenu wechatMenu = wechatMenuRepository.findById(menuId)
            .orElseThrow(() -> new BusinessException(Resp.WECHAT_MENU_NOT_FOUND));
        
        wechatMenu.enable();
        wechatMenuRepository.save(wechatMenu);
        
        log.info("微信菜单启用成功，菜单ID: {}", menuId);
    }
    
    @Override
    @Transactional
    public void disableWechatMenu(Long menuId) {
        log.info("禁用微信菜单，菜单ID: {}", menuId);
        
        WechatMenu wechatMenu = wechatMenuRepository.findById(menuId)
            .orElseThrow(() -> new BusinessException(Resp.WECHAT_MENU_NOT_FOUND));
        
        wechatMenu.disable();
        wechatMenuRepository.save(wechatMenu);
        
        log.info("微信菜单禁用成功，菜单ID: {}", menuId);
    }

    @Override
    public List<WechatMenuResponse> getWechatMenusByState(Integer menuState) {
        return Collections.emptyList();
    }

    /**
     * 转换为响应DTO
     */
    private WechatMenuResponse convertToResponse(WechatMenu wechatMenu) {
        WechatMenuResponse response = new WechatMenuResponse();
        response.setMenuId(wechatMenu.getMenuId());
        response.setClickMsgType(wechatMenu.getClickMsgType());
        response.setMenuKey(wechatMenu.getMenuKey());
        response.setMenuName(wechatMenu.getMenuName());
        response.setMenuReplyData(wechatMenu.getMenuReplyData());
        response.setMenuSort(wechatMenu.getMenuSort());
        response.setMenuState(wechatMenu.getMenuState());
        response.setMenuType(wechatMenu.getMenuType());
        response.setMenuViewUrl(wechatMenu.getMenuViewUrl());
        response.setParentId(wechatMenu.getParentId());
        response.setParentName(wechatMenu.getParentName());
        response.setCreatedAt(wechatMenu.getCreatedAt());
        response.setUpdatedAt(wechatMenu.getUpdatedAt());
        return response;
    }
}