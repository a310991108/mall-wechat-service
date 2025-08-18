package com.mall.wechat.application.service;

import com.mall.wechat.application.dto.WechatMenuResponse;
import com.mall.wechat.application.port.in.WechatMenuGetByStateUseCase;

import java.util.Collections;
import java.util.List;

public class WechatMenuGetByStateService implements WechatMenuGetByStateUseCase {
    @Override
    public List<WechatMenuResponse> getWechatMenusByState(Integer menuState) {
        return Collections.emptyList();
    }
}
