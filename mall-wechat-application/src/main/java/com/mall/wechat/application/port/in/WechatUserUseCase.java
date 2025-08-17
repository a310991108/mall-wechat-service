package com.mall.wechat.application.port.in;

import com.mall.wechat.application.command.CreateWechatUserCommand;
import com.mall.wechat.application.command.UpdateWechatUserCommand;
import com.mall.wechat.application.dto.WechatUserResponse;

import java.util.List;

/**
 * 微信用户用例接口
 */
public interface WechatUserUseCase {
    
    /**
     * 创建微信用户
     */
    WechatUserResponse createWechatUser(CreateWechatUserCommand command);
    
    /**
     * 更新微信用户
     */
    WechatUserResponse updateWechatUser(UpdateWechatUserCommand command);
    
    /**
     * 根据OpenID查询微信用户
     */
    WechatUserResponse getWechatUserByOpenId(String openId);
    
    /**
     * 根据ID查询微信用户
     */
    WechatUserResponse getWechatUserById(Long userId);
    
    /**
     * 查询所有微信用户
     */
    List<WechatUserResponse> getAllWechatUsers();
    
    /**
     * 删除微信用户
     */
    void deleteWechatUser(Long userId);
}