package com.mall.wechat.application.service;

import com.mall.wechat.application.dto.WechatUserResponse;
import com.mall.wechat.application.port.in.WechatUserGetByIdUseCase;
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
public class WechatUserGetByIdService implements WechatUserGetByIdUseCase {
    /**
     * 根据ID查询微信用户
     */
    @Override
    public WechatUserResponse getWechatUserById(Long userId) {
        return null;
    }
}
