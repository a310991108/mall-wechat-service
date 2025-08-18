package com.mall.wechat.application.port.in;

import com.mall.wechat.application.dto.WechatMenuResponse;

import java.util.List;

public interface WechatMenuGetByStateUseCase {
    /**
     * 根据菜单状态查询菜单列表
     */
    List<WechatMenuResponse> getWechatMenusByState(Integer menuState);
}
