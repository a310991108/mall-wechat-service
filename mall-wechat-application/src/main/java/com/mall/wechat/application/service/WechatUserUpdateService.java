package com.mall.wechat.application.service;

import com.mall.wechat.application.command.UpdateWechatUserCommand;
import com.mall.wechat.application.dto.WechatUserResponse;
import com.mall.wechat.application.port.in.WechatUserUpdateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class WechatUserUpdateService implements WechatUserUpdateUseCase {
    /**
     * 更新微信用户
     */
    @Override
    public WechatUserResponse updateWechatUser(UpdateWechatUserCommand command) {
        return null;
    }
}
