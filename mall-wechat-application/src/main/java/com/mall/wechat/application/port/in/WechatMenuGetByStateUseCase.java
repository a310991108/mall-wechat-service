package com.mall.wechat.application.port.in;

import com.mall.wechat.application.dto.WechatMenuResponse;

import java.util.List;
/**
 * 微信菜单用例接口
 * @author zhangyong
 */
public interface WechatMenuGetByStateUseCase {
    /**
     * 根据菜单状态查询菜单列表
     */
    List<WechatMenuResponse> getWechatMenusByState(Integer menuState);
}
