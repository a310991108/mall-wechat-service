package com.mall.wechat.application.port.out;

import com.mall.wechat.domain.model.wechatuser.WechatUser;

import java.util.List;
import java.util.Optional;

/**
 * 微信用户仓储接口
 */
public interface WechatUserRepository {
    
    /**
     * 保存微信用户
     */
    WechatUser save(WechatUser wechatUser);
    
    /**
     * 根据ID查询微信用户
     */
    Optional<WechatUser> findById(Long userId);
    
    /**
     * 根据OpenID查询微信用户
     */
    Optional<WechatUser> findByOpenId(String openId);
    
    /**
     * 查询所有微信用户
     */
    List<WechatUser> findAll();
    
    /**
     * 根据标签ID查询微信用户
     */
    List<WechatUser> findByWechatTagId(String wechatTagId);
    
    /**
     * 删除微信用户
     */
    void deleteById(Long userId);
    
    /**
     * 检查OpenID是否存在
     */
    boolean existsByOpenId(String openId);
}