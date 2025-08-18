package com.mall.wechat.application.port.in;

public interface WechatUserDeleteUseCase {
    /**
     * 删除微信用户
     */
    void deleteWechatUser(Long userId);
}
