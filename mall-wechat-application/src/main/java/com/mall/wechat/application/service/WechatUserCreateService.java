package com.mall.wechat.application.service;

import com.mall.wechat.application.command.CreateWechatUserCommand;
import com.mall.wechat.application.dto.WechatUserResponse;
import com.mall.wechat.application.port.in.WechatUserCreateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * 微信用户接口实现
 * @author zhangyong
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WechatUserCreateService implements WechatUserCreateUseCase {
    /**
     * 创建微信用户
     */
    @Override
    public WechatUserResponse createWechatUser(CreateWechatUserCommand command) {
        return null;
    }
}
