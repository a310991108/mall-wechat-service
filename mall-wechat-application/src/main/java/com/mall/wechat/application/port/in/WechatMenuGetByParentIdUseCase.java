package com.mall.wechat.application.port.in;

import com.mall.wechat.application.dto.WechatMenuResponse;

import java.util.List;

public interface WechatMenuGetByParentIdUseCase {
    /**
     * 根据父菜单ID查询子菜单
     */
    List<WechatMenuResponse> getWechatMenusByParentId(Integer parentId);
}
