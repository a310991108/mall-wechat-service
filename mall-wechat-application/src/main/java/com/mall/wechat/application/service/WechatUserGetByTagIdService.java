package com.mall.wechat.application.service;

import com.mall.wechat.application.dto.WechatUserResponse;
import com.mall.wechat.application.port.in.WechatUserGetByTagIdUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 微信用户接口实现
 * @author zhangyong
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WechatUserGetByTagIdService implements WechatUserGetByTagIdUseCase {
    @Override
    public List<WechatUserResponse> getWechatUsersByTagId(String wechatTagId) {
        return null;
    }
}
