package com.mall.wechat.adapter.out.persistence.repository;

import com.mall.wechat.adapter.out.persistence.mapper.WechatAutoReplyRuleMapper;
import com.mall.wechat.application.port.out.WechatAutoReplyRuleRepository;
import com.mall.wechat.domain.model.autoreply.WechatAutoReplyRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 微信自动回复规则仓储实现
 */
@Repository
@RequiredArgsConstructor
public class WechatAutoReplyRuleRepositoryImpl implements WechatAutoReplyRuleRepository {
    
    private final WechatAutoReplyRuleMapper autoReplyRuleMapper;
    
    @Override
    public WechatAutoReplyRule save(WechatAutoReplyRule rule) {
        if (rule.getRuleId() == null) {
            autoReplyRuleMapper.insert(rule);
        } else {
            autoReplyRuleMapper.updateById(rule);
        }
        return rule;
    }
    
    @Override
    public Optional<WechatAutoReplyRule> findById(Long ruleId) {
        WechatAutoReplyRule rule = autoReplyRuleMapper.selectById(ruleId);
        return Optional.ofNullable(rule);
    }
    
    @Override
    public List<WechatAutoReplyRule> findAll() {
        return autoReplyRuleMapper.selectList(null);
    }
    
    @Override
    public List<WechatAutoReplyRule> findByRuleState(Integer ruleState) {
        return autoReplyRuleMapper.findByRuleState(ruleState);
    }
    
    @Override
    public List<WechatAutoReplyRule> findByMatchType(String matchType) {
        return autoReplyRuleMapper.findByMatchType(matchType);
    }
    
    @Override
    public void deleteById(Long ruleId) {
        autoReplyRuleMapper.deleteById(ruleId);
    }
}