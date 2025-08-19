package com.mall.wechat.application.service;

import com.mall.wechat.application.command.UpdateWechatMenuCommand;
import com.mall.wechat.application.dto.WechatMenuResponse;
import com.mall.wechat.application.port.in.WechatMenuUpdateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 微信菜单接口实现
 * @author zhangyong
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WechatMenuUpdateService implements WechatMenuUpdateUseCase {
    /**
     * 更新微信菜单
     */
    @Override
    public WechatMenuResponse updateWechatMenu(Long menuId,UpdateWechatMenuCommand command) {
        return null;
    }
}
