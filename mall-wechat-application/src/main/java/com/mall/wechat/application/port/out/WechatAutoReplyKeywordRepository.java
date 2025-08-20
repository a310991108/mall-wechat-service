package com.mall.wechat.application.port.out;

import com.mall.wechat.domain.model.autoreply.WechatAutoReplyKeyword;

import java.util.List;
import java.util.Optional;
/**
 * 微信自动回复关键词仓储接口
 */
public interface WechatAutoReplyKeywordRepository {
    WechatAutoReplyKeyword save(WechatAutoReplyKeyword keyword);
    Optional<WechatAutoReplyKeyword> findById(Long keywordId);
    List<WechatAutoReplyKeyword> findAll();
    List<WechatAutoReplyKeyword> findByRuleId(Long ruleId);
    List<WechatAutoReplyKeyword> findByKeyword(String keyword);
    void deleteById(Long keywordId);
}
