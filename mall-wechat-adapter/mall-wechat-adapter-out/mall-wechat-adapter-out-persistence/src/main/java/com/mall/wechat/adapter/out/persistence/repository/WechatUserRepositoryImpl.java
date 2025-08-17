package com.mall.wechat.adapter.out.persistence.repository;

import com.mall.wechat.adapter.out.persistence.mapper.WechatUserMapper;
import com.mall.wechat.application.port.out.WechatUserRepository;
import com.mall.wechat.domain.model.wechatuser.WechatUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 微信用户仓储实现
 */
@Repository
@RequiredArgsConstructor
public class WechatUserRepositoryImpl implements WechatUserRepository {
    
    private final WechatUserMapper wechatUserMapper;
    
    @Override
    public WechatUser save(WechatUser wechatUser) {
        if (wechatUser.getUserId() == null) {
            wechatUserMapper.insert(wechatUser);
        } else {
            wechatUserMapper.updateById(wechatUser);
        }
        return wechatUser;
    }
    
    @Override
    public Optional<WechatUser> findById(Long userId) {
        WechatUser wechatUser = wechatUserMapper.selectById(userId);
        return Optional.ofNullable(wechatUser);
    }
    
    @Override
    public Optional<WechatUser> findByOpenId(String openId) {
        WechatUser wechatUser = wechatUserMapper.findByOpenId(openId);
        return Optional.ofNullable(wechatUser);
    }
    
    @Override
    public List<WechatUser> findAll() {
        return wechatUserMapper.selectList(null);
    }
    
    @Override
    public List<WechatUser> findByWechatTagId(String wechatTagId) {
        return wechatUserMapper.findByWechatTagId(wechatTagId);
    }
    
    @Override
    public void deleteById(Long userId) {
        wechatUserMapper.deleteById(userId);
    }
    
    @Override
    public boolean existsByOpenId(String openId) {
        return wechatUserMapper.countByOpenId(openId) > 0;
    }
}