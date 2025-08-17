package com.mall.wechat.adapter.out.persistence.repository;

import com.mall.wechat.adapter.out.persistence.mapper.WechatAutoReplyContentMapper;
import com.mall.wechat.application.port.out.WechatAutoReplyContentRepository;
import com.mall.wechat.domain.model.autoreply.WechatAutoReplyContent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 微信自动回复内容仓储实现
 */
@Repository
@RequiredArgsConstructor
public class WechatAutoReplyContentRepositoryImpl implements WechatAutoReplyContentRepository {
    
    private final WechatAutoReplyContentMapper contentMapper;
    
    @Override
    public WechatAutoReplyContent save(WechatAutoReplyContent content) {
        if (content.getContentId() == null) {
            contentMapper.insert(content);
        } else {
            contentMapper.updateById(content);
        }
        return content;
    }
    
    @Override
    public Optional<WechatAutoReplyContent> findById(Long contentId) {
        WechatAutoReplyContent content = contentMapper.selectById(contentId);
        return Optional.ofNullable(content);
    }
    
    @Override
    public List<WechatAutoReplyContent> findAll() {
        return contentMapper.selectList(null);
    }
    
    @Override
    public List<WechatAutoReplyContent> findByRuleId(Long ruleId) {
        return contentMapper.findByRuleId(ruleId);
    }
    
    @Override
    public List<WechatAutoReplyContent> findByMsgType(String msgType) {
        return contentMapper.findByMsgType(msgType);
    }
    
    @Override
    public void deleteById(Long contentId) {
        contentMapper.deleteById(contentId);
    }
}