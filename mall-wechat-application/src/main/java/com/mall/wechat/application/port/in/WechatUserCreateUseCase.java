package com.mall.wechat.application.port.in;

import com.mall.wechat.application.command.CreateWechatUserCommand;
import com.mall.wechat.application.dto.WechatUserResponse;
/**
 * 微信用户用例接口
 * @author zhangyong
 */
public interface WechatUserCreateUseCase {
    /**
     * 创建微信用户
     */
    WechatUserResponse createWechatUser(CreateWechatUserCommand command);
}
