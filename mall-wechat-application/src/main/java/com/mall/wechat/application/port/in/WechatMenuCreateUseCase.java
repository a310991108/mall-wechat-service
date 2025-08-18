package com.mall.wechat.application.port.in;

import com.mall.wechat.application.command.CreateWechatMenuCommand;
import com.mall.wechat.application.dto.WechatMenuResponse;

public interface WechatMenuCreateUseCase {
    /**
     * 创建微信菜单
     */
    WechatMenuResponse createWechatMenu(CreateWechatMenuCommand command);
}
