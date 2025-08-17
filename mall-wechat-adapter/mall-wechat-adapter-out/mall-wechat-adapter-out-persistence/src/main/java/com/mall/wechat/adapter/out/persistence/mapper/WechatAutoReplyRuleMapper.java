package com.mall.wechat.adapter.out.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.wechat.domain.model.autoreply.WechatAutoReplyRule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微信自动回复规则Mapper接口
 */
@Mapper
public interface WechatAutoReplyRuleMapper extends BaseMapper<WechatAutoReplyRule> {
    
    /**
     * 根据规则状态查询规则
     */
    List<WechatAutoReplyRule> findByRuleState(@Param("ruleState") Integer ruleState);
    
    /**
     * 根据匹配类型查询规则
     */
    List<WechatAutoReplyRule> findByMatchType(@Param("matchType") String matchType);
}