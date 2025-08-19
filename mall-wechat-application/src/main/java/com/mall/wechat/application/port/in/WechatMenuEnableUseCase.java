package com.mall.wechat.application.port.in;

/**
 * 微信菜单用例接口
 * @author zhangyong
 */
public interface WechatMenuEnableUseCase {
    /**
     * 启用微信菜单
     */
    void enableWechatMenu(Long menuId);
}
