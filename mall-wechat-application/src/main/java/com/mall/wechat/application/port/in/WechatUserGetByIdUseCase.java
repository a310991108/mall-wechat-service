package com.mall.wechat.application.port.in;

import com.mall.wechat.application.dto.WechatUserResponse;

public interface WechatUserGetByIdUseCase {
    /**
     * 根据ID查询微信用户
     */
    WechatUserResponse getWechatUserById(Long userId);
}
