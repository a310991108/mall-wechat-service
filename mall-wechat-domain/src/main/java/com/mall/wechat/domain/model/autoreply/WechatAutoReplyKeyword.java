package com.mall.wechat.domain.model.autoreply;

import com.baomidou.mybatisplus.annotation.*;
import com.mall.wechat.common.exception.BusinessException;
import com.mall.wechat.common.enums.Resp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 微信自动回复关键词领域实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("wechat_auto_reply_keyword")
public class WechatAutoReplyKeyword {
    
    @TableId(value = "keyword_id", type = IdType.AUTO)
    private Long keywordId;
    
    /**
     * 是否全匹配：0-否，1-是
     */
    private Integer fullMatch;
    
    /**
     * 关键词名称
     */
    private String keywordName;
    
    /**
     * 规则ID
     */
    private Integer ruleId;
    
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
     * 创建关键词
     */
    public static WechatAutoReplyKeyword create(String keywordName, Integer ruleId, Integer fullMatch) {
        if (keywordName == null || keywordName.trim().isEmpty()) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        if (ruleId == null) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        
        WechatAutoReplyKeyword keyword = new WechatAutoReplyKeyword();
        keyword.setKeywordName(keywordName.trim());
        keyword.setRuleId(ruleId);
        keyword.setFullMatch(fullMatch != null ? fullMatch : 0);
        return keyword;
    }
    
    /**
     * 设置全匹配
     */
    public void setFullMatch() {
        this.fullMatch = 1;
    }
    
    /**
     * 设置模糊匹配
     */
    public void setPartialMatch() {
        this.fullMatch = 0;
    }
    
    /**
     * 判断是否全匹配
     */
    public boolean isFullMatch() {
        return this.fullMatch != null && this.fullMatch == 1;
    }
}