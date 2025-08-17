package com.mall.wechat.domain.model.autoreply;

import com.baomidou.mybatisplus.annotation.*;
import com.mall.wechat.common.exception.BusinessException;
import com.mall.wechat.common.enums.Resp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 微信自动回复内容领域实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("wechat_auto_reply_content")
public class WechatAutoReplyContent {
    
    @TableId(value = "content_id", type = IdType.AUTO)
    private Long contentId;
    
    /**
     * 消息类型
     */
    private String msgType;
    
    /**
     * 回复数据
     */
    private String replyData;
    
    /**
     * 回复类型
     */
    private String replyType;
    
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
     * 创建回复内容
     */
    public static WechatAutoReplyContent create(String msgType, String replyType, String replyData, Integer ruleId) {
        if (msgType == null || msgType.trim().isEmpty()) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        if (replyType == null || replyType.trim().isEmpty()) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        if (replyData == null || replyData.trim().isEmpty()) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        if (ruleId == null) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        
        WechatAutoReplyContent content = new WechatAutoReplyContent();
        content.setMsgType(msgType);
        content.setReplyType(replyType);
        content.setReplyData(replyData);
        content.setRuleId(ruleId);
        return content;
    }
    
    /**
     * 更新回复数据
     */
    public void updateReplyData(String replyData) {
        if (replyData == null || replyData.trim().isEmpty()) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        this.replyData = replyData;
    }
}