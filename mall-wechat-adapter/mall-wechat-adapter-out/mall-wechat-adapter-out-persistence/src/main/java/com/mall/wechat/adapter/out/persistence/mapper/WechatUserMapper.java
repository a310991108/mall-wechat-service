package com.mall.wechat.adapter.out.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.wechat.domain.model.wechatuser.WechatUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微信用户Mapper接口
 */
@Mapper
public interface WechatUserMapper extends BaseMapper<WechatUser> {
    
    /**
     * 根据OpenID查询微信用户
     */
    WechatUser findByOpenId(@Param("openId") String openId);
    
    /**
     * 根据标签ID查询微信用户列表
     */
    List<WechatUser> findByWechatTagId(@Param("wechatTagId") String wechatTagId);
    
    /**
     * 检查OpenID是否存在
     */
    int countByOpenId(@Param("openId") String openId);
}