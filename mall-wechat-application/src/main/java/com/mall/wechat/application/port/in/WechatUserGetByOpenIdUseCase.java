package com.mall.wechat.application.port.in;

import com.mall.wechat.application.dto.WechatUserResponse;

public interface WechatUserGetByOpenIdUseCase {
    /**
     * 根据OpenID查询微信用户
     */
    WechatUserResponse getWechatUserByOpenId(String openId);
}
