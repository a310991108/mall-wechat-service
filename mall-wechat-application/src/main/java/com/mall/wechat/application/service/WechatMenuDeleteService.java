package com.mall.wechat.application.service;

import com.mall.wechat.application.port.in.WechatMenuDeleteUseCase;
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
public class WechatMenuDeleteService implements WechatMenuDeleteUseCase {
    /**
     * 删除微信菜单
     */
    @Override
    public void deleteWechatMenu(Long menuId) {

    }
}
