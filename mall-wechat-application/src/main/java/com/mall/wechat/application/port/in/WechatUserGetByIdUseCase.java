package com.mall.wechat.application.port.in;

import com.mall.wechat.application.dto.WechatUserResponse;
/**
 * 微信用户用例接口
 * @author zhangyong
 */
public interface WechatUserGetByIdUseCase {
    /**
     * 根据ID查询微信用户
     */
    WechatUserResponse getWechatUserById(Long userId);
}
