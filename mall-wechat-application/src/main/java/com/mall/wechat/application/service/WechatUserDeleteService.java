package com.mall.wechat.application.service;

import com.mall.wechat.application.port.in.WechatUserDeleteUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WechatUserDeleteService implements WechatUserDeleteUseCase {
    /**
     * 删除微信用户
     */
    @Override
    public void deleteWechatUser(Long userId) {

    }
}
