package com.mall.wechat.application.port.in;

/**
 * 微信菜单用例接口
 * @author zhangyong
 */
public interface WechatMenuDisableUseCase {
    /**
     * 禁用微信菜单
     */
    void disableWechatMenu(Long menuId);
}
