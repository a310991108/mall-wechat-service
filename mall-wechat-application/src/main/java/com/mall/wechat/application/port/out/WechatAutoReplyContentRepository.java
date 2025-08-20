package com.mall.wechat.application.port.out;

import com.mall.wechat.domain.model.autoreply.WechatAutoReplyContent;

import java.util.List;
import java.util.Optional;
/**
 * 微信自动回复内容仓储接口
 */
public interface WechatAutoReplyContentRepository {
    WechatAutoReplyContent save(WechatAutoReplyContent content);
    Optional<WechatAutoReplyContent> findById(Long contentId);
    List<WechatAutoReplyContent> findAll();
    List<WechatAutoReplyContent> findByRuleId(Long ruleId);
    List<WechatAutoReplyContent> findByMsgType(String msgType);
    void deleteById(Long contentId);
}
