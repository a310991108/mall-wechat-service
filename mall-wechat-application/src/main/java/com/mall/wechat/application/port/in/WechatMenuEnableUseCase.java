package com.mall.wechat.application.port.in;

public interface WechatMenuEnableUseCase {
    /**
     * 启用微信菜单
     */
    void enableWechatMenu(Long menuId);
}
