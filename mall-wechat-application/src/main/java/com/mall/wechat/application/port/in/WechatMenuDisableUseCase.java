package com.mall.wechat.application.port.in;

public interface WechatMenuDisableUseCase {
    /**
     * 禁用微信菜单
     */
    void disableWechatMenu(Long menuId);
}
