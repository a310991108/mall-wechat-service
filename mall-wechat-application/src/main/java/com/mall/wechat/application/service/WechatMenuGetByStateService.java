package com.mall.wechat.application.service;

import com.mall.wechat.application.dto.WechatMenuResponse;
import com.mall.wechat.application.port.in.WechatMenuGetByStateUseCase;

import java.util.Collections;
import java.util.List;

public class WechatMenuGetByStateService implements WechatMenuGetByStateUseCase {
    /**
     * 根据菜单状态查询菜单列表
     */
    @Override
    public List<WechatMenuResponse> getWechatMenusByState(Integer menuState) {
        return Collections.emptyList();
    }
}
