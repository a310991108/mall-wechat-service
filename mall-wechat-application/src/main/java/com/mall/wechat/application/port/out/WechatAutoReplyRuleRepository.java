package com.mall.wechat.application.port.out;

import com.mall.wechat.domain.model.autoreply.WechatAutoReplyRule;

import java.util.List;
import java.util.Optional;
/**
 * 微信自动回复规则仓储接口
 */
public interface WechatAutoReplyRuleRepository {
    WechatAutoReplyRule save(WechatAutoReplyRule rule);
    Optional<WechatAutoReplyRule> findById(Long ruleId);
    List<WechatAutoReplyRule> findAll();
    List<WechatAutoReplyRule> findByRuleState(Integer ruleState);
    List<WechatAutoReplyRule> findByMatchType(String matchType);
    void deleteById(Long ruleId);
}
