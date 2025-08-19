package com.mall.wechat.application.service;

import com.mall.wechat.application.dto.WechatUserResponse;
import com.mall.wechat.application.port.in.WechatUserGetAllUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
/**
 * 微信用户接口实现
 * @author zhangyong
 */
public class WechatUserGetAllService implements WechatUserGetAllUseCase {
    /**
     * 查询所有微信用户
     */
    @Override
    public List<WechatUserResponse> getAllWechatUsers() {
        return Collections.emptyList();
    }
}
