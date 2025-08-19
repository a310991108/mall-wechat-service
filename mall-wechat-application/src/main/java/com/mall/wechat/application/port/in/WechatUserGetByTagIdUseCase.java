package com.mall.wechat.application.port.in;

import com.mall.wechat.application.dto.WechatUserResponse;

import java.util.List;

/**
 * 微信用户用例接口
 * @author zhangyong
 */
public interface WechatUserGetByTagIdUseCase {
    /**
     * 查询用户标签
     */
    List<WechatUserResponse> getWechatUsersByTagId(String wechatTagId);
}
