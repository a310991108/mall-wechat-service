package com.mall.wechat.application.port.in;

import com.mall.wechat.application.command.UpdateWechatMenuCommand;
import com.mall.wechat.application.dto.WechatMenuResponse;

public interface WechatMenuUpdateUseCase {
    /**
     * 更新微信菜单
     */
    WechatMenuResponse updateWechatMenu(UpdateWechatMenuCommand command);
}
