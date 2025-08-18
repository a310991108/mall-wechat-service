package com.mall.wechat.application.port.in;
/**
 * 微信用户用例接口
 * @author zhangyong
 */
public interface WechatUserDeleteUseCase {
    /**
     * 删除微信用户
     */
    void deleteWechatUser(Long userId);
}
