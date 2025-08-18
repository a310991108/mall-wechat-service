package com.mall.wechat.application.port.in;

import com.mall.wechat.application.dto.WechatMenuResponse;
/**
 * 微信菜单用例接口
 * @author zhangyong
 */
public interface WechatMenuGetByIdUseCase {
    /**
     * 根据ID查询微信菜单
     */
    WechatMenuResponse getWechatMenuById(Long menuId);
}
