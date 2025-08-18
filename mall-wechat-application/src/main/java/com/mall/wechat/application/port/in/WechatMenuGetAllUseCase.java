package com.mall.wechat.application.port.in;

import com.mall.wechat.application.dto.WechatMenuResponse;

import java.util.List;

/**
 * 微信菜单用例接口
 * @author zhangyong
 */
public interface WechatMenuGetAllUseCase {
    /**
     * 查询所有微信菜单
     */
    List<WechatMenuResponse> getAllWechatMenus();
}
