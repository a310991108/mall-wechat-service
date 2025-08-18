package com.mall.wechat.application.service;

import com.mall.wechat.application.dto.WechatUserResponse;
import com.mall.wechat.application.port.in.WechatUserGetByOpenIdUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
/**
 * 微信用户接口实现
 * @author zhangyong
 */
public class WechatUserGetByOpenIdService implements WechatUserGetByOpenIdUseCase {
    /**
     * 根据OpenID查询微信用户
     */
    @Override
    public WechatUserResponse getWechatUserByOpenId(String openId) {
        return null;
    }
}
