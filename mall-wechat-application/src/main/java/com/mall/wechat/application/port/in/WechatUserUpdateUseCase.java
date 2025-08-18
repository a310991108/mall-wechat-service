package com.mall.wechat.application.port.in;

import com.mall.wechat.application.command.UpdateWechatUserCommand;
import com.mall.wechat.application.dto.WechatUserResponse;

public interface WechatUserUpdateUseCase {
    /**
     * 更新微信用户
     */
    WechatUserResponse updateWechatUser(UpdateWechatUserCommand command);
}
