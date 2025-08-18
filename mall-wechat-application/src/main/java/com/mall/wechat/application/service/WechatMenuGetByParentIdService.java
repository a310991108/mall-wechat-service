package com.mall.wechat.application.service;

import com.mall.wechat.application.dto.WechatMenuResponse;
import com.mall.wechat.application.port.in.WechatMenuGetByParentIdUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WechatMenuGetByParentIdService implements WechatMenuGetByParentIdUseCase {
    /**
     * 根据父菜单ID查询子菜单
     */
    @Override
    public List<WechatMenuResponse> getWechatMenusByParentId(Integer parentId) {
        return Collections.emptyList();
    }
}
