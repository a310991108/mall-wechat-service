package com.mall.wechat.application.service;

import com.mall.wechat.application.dto.WechatMenuResponse;
import com.mall.wechat.application.port.in.WechatMenuGetByStateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
/**
 * 微信菜单接口实现
 * @author zhangyong
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WechatMenuGetByStateService implements WechatMenuGetByStateUseCase {
    /**
     * 根据菜单状态查询菜单列表
     */
    @Override
    public List<WechatMenuResponse> getWechatMenusByState(Integer menuState) {
        return Collections.emptyList();
    }
}
