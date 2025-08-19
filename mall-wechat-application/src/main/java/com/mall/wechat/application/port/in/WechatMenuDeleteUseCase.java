package com.mall.wechat.application.port.in;

/**
 * 微信菜单用例接口
 * @author zhangyong
 */
public interface WechatMenuDeleteUseCase {
    /**
     * 删除微信菜单
     */
    void deleteWechatMenu(Long menuId);
}
