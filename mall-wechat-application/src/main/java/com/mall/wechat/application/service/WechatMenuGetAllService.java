package com.mall.wechat.application.service;

import com.mall.wechat.application.dto.WechatMenuResponse;
import com.mall.wechat.application.port.in.WechatMenuGetAllUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
/**
 * 微信菜单接口实现
 * @author zhangyong
 */
public class WechatMenuGetAllService implements WechatMenuGetAllUseCase {
    /**
     * 查询所有微信菜单
     */
    @Override
    public List<WechatMenuResponse> getAllWechatMenus() {
        return Collections.emptyList();
    }
}
