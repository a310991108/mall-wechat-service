package com.mall.wechat.domain.model.autoreply;

import com.baomidou.mybatisplus.annotation.*;
import com.mall.wechat.common.exception.BusinessException;
import com.mall.wechat.common.enums.Resp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 微信自动回复规则领域实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("wechat_auto_reply_rule")
public class WechatAutoReplyRule {
    
    @TableId(value = "rule_id", type = IdType.AUTO)
    private Long ruleId;
    
    /**
     * 所有关键词
     */
    private String allKeyword;
    
    /**
     * 是否回复全部：0-否，1-是
     */
    private Integer replyAll;
    
    /**
     * 回复数量
     */
    private Integer replyCount;
    
    /**
     * 回复类型统计
     */
    private String replyTypeCount;
    
    /**
     * 规则名称
     */
    private String ruleName;
    
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
    
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createdBy;
    
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
    
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updatedBy;
    
    /**
     * 是否删除：0-未删除，1-已删除
     */
    @TableLogic
    private Integer isDeleted;
    
    /**
     * 创建自动回复规则
     */
    public static WechatAutoReplyRule create(String ruleName, Integer replyAll) {
        if (ruleName == null || ruleName.trim().isEmpty()) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        
        WechatAutoReplyRule rule = new WechatAutoReplyRule();
        rule.setRuleName(ruleName);
        rule.setReplyAll(replyAll != null ? replyAll : 0);
        rule.setReplyCount(0);
        return rule;
    }
    
    /**
     * 更新关键词信息
     */
    public void updateKeywords(String allKeyword) {
        this.allKeyword = allKeyword;
    }
    
    /**
     * 更新回复统计
     */
    public void updateReplyStats(Integer replyCount, String replyTypeCount) {
        this.replyCount = replyCount != null ? replyCount : 0;
        this.replyTypeCount = replyTypeCount;
    }
}