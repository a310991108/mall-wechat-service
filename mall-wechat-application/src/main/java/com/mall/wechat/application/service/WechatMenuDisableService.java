package com.mall.wechat.application.service;

import com.mall.wechat.application.port.in.WechatMenuDisableUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WechatMenuDisableService implements WechatMenuDisableUseCase {
    /**
     * 禁用微信菜单
     */
    @Override
    public void disableWechatMenu(Long menuId) {

    }
}
