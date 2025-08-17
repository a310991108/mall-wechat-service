package com.mall.wechat.adapter.out.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.wechat.domain.model.autoreply.WechatAutoReplyContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微信自动回复内容Mapper接口
 */
@Mapper
public interface WechatAutoReplyContentMapper extends BaseMapper<WechatAutoReplyContent> {
    
    /**
     * 根据规则ID查询回复内容
     */
    List<WechatAutoReplyContent> findByRuleId(@Param("ruleId") Long ruleId);
    
    /**
     * 根据消息类型查询回复内容
     */
    List<WechatAutoReplyContent> findByMsgType(@Param("msgType") String msgType);
}