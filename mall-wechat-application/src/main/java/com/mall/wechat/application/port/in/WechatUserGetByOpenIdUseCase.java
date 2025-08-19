package com.mall.wechat.application.port.in;

import com.mall.wechat.application.dto.WechatUserResponse;
/**
 * 微信用户用例接口
 * @author zhangyong
 */
public interface WechatUserGetByOpenIdUseCase {
    /**
     * 根据OpenID查询微信用户
     */
    WechatUserResponse getWechatUserByOpenId(String openId);
}
