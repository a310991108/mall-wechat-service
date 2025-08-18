package com.mall.wechat.application.port.in;

import com.mall.wechat.application.dto.WechatUserResponse;

import java.util.List;

public interface WechatUserGetAllUseCase {
    /**
     * 查询所有微信用户
     */
    List<WechatUserResponse> getAllWechatUsers();
}
