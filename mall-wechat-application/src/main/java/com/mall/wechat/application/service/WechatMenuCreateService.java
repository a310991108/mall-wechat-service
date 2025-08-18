package com.mall.wechat.application.service;

import com.mall.wechat.application.command.CreateWechatMenuCommand;
import com.mall.wechat.application.dto.WechatMenuResponse;
import com.mall.wechat.application.port.in.WechatMenuCreateUseCase;
import com.mall.wechat.application.port.out.WechatMenuRepository;
import com.mall.wechat.domain.model.menu.WechatMenu;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
/**
 * 微信菜单接口实现
 * @author zhangyong
 */
public class WechatMenuCreateService implements WechatMenuCreateUseCase {

    private final WechatMenuRepository wechatMenuRepository;
    /**
     * 创建微信菜单
     */
    @Override
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
