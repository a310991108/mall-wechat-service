package com.mall.wechat.application.service;

import com.mall.wechat.application.port.in.WechatMenuEnableUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
/**
 * 微信菜单接口实现
 * @author zhangyong
 */
public class WechatMenuEnableService implements WechatMenuEnableUseCase {
    /**
     * 启用微信菜单
     */
    @Override
    public void enableWechatMenu(Long menuId) {

    }
}
