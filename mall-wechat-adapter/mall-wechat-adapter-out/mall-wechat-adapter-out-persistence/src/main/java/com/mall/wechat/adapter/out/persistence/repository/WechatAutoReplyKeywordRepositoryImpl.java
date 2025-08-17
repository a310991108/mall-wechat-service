package com.mall.wechat.adapter.out.persistence.repository;

import com.mall.wechat.adapter.out.persistence.mapper.WechatAutoReplyKeywordMapper;
import com.mall.wechat.application.port.out.WechatAutoReplyKeywordRepository;
import com.mall.wechat.domain.model.autoreply.WechatAutoReplyKeyword;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 微信自动回复关键词仓储实现
 */
@Repository
@RequiredArgsConstructor
public class WechatAutoReplyKeywordRepositoryImpl implements WechatAutoReplyKeywordRepository {
    
    private final WechatAutoReplyKeywordMapper keywordMapper;
    
    @Override
    public WechatAutoReplyKeyword save(WechatAutoReplyKeyword keyword) {
        if (keyword.getKeywordId() == null) {
            keywordMapper.insert(keyword);
        } else {
            keywordMapper.updateById(keyword);
        }
        return keyword;
    }
    
    @Override
    public Optional<WechatAutoReplyKeyword> findById(Long keywordId) {
        WechatAutoReplyKeyword keyword = keywordMapper.selectById(keywordId);
        return Optional.ofNullable(keyword);
    }
    
    @Override
    public List<WechatAutoReplyKeyword> findAll() {
        return keywordMapper.selectList(null);
    }
    
    @Override
    public List<WechatAutoReplyKeyword> findByRuleId(Long ruleId) {
        return keywordMapper.findByRuleId(ruleId);
    }
    
    @Override
    public List<WechatAutoReplyKeyword> findByKeyword(String keyword) {
        return keywordMapper.findByKeyword(keyword);
    }
    
    @Override
    public void deleteById(Long keywordId) {
        keywordMapper.deleteById(keywordId);
    }
}