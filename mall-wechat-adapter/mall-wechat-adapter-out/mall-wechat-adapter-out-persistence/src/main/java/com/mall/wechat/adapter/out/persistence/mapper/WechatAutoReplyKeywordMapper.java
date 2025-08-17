package com.mall.wechat.adapter.out.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.wechat.domain.model.autoreply.WechatAutoReplyKeyword;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微信自动回复关键词Mapper接口
 */
@Mapper
public interface WechatAutoReplyKeywordMapper extends BaseMapper<WechatAutoReplyKeyword> {
    
    /**
     * 根据规则ID查询关键词
     */
    List<WechatAutoReplyKeyword> findByRuleId(@Param("ruleId") Long ruleId);
    
    /**
     * 根据关键词查询
     */
    List<WechatAutoReplyKeyword> findByKeyword(@Param("keyword") String keyword);
}