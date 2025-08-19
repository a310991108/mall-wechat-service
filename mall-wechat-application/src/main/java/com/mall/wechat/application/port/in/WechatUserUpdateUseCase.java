package com.mall.wechat.application.port.in;

import com.mall.wechat.application.command.UpdateWechatUserCommand;
import com.mall.wechat.application.dto.WechatUserResponse;
/**
 * 微信用户用例接口
 * @author zhangyong
 */
public interface WechatUserUpdateUseCase {
    /**
     * 更新微信用户
     */
    WechatUserResponse updateWechatUser(UpdateWechatUserCommand command);
}
