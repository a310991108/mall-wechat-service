package com.mall.wechat.application.service;

import com.mall.wechat.application.dto.WechatMenuResponse;
import com.mall.wechat.application.port.in.WechatMenuGetByIdUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * 微信菜单接口实现
 * @author zhangyong
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WechatMenuGetByIdService implements WechatMenuGetByIdUseCase {
    /**
     * 根据ID查询微信菜单
     */
    @Override
    public WechatMenuResponse getWechatMenuById(Long menuId) {
        return null;
    }
}
