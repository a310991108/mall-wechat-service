package com.mall.wechat.application.port.in;

public interface WechatMenuDeleteUseCase {
    /**
     * 删除微信菜单
     */
    void deleteWechatMenu(Long menuId);
}
