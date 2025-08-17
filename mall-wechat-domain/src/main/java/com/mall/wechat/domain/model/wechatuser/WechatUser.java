package com.mall.wechat.domain.model.wechatuser;

import com.baomidou.mybatisplus.annotation.*;
import com.mall.wechat.common.exception.BusinessException;
import com.mall.wechat.common.enums.Resp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 微信用户领域实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("wechat_user")
public class WechatUser {
    
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    
    /**
     * 城市
     */
    private String city;
    
    /**
     * 国家
     */
    private String country;
    
    /**
     * 分组ID
     */
    private Integer groupId;
    
    /**
     * 头像URL
     */
    private String headImgUrl;
    
    /**
     * 语言
     */
    private String language;
    
    /**
     * 昵称
     */
    private String nickName;
    
    /**
     * 微信OpenID
     */
    private String openId;
    
    /**
     * 省份
     */
    private String province;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 性别：0-未知，1-男，2-女
     */
    private Integer sex;
    
    /**
     * 关注时间
     */
    private LocalDateTime subscribeTime;
    
    /**
     * 微信UnionID
     */
    private String unionId;
    
    /**
     * 微信标签ID
     */
    private String wechatTagId;
    
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
     * 创建微信用户
     */
    public static WechatUser create(String openId, String nickName, Integer sex, LocalDateTime subscribeTime) {
        if (openId == null || openId.trim().isEmpty()) {
            throw new BusinessException(Resp.OPENID_MISSING);
        }
        if (nickName == null || nickName.trim().isEmpty()) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        
        WechatUser user = new WechatUser();
        user.setOpenId(openId);
        user.setNickName(nickName);
        user.setSex(sex != null ? sex : 0);
        user.setSubscribeTime(subscribeTime != null ? subscribeTime : LocalDateTime.now());
        return user;
    }
    
    /**
     * 更新用户信息
     */
    public void updateUserInfo(String nickName, String headImgUrl, Integer sex, String city, String province, String country, String language) {
        if (nickName != null && !nickName.trim().isEmpty()) {
            this.nickName = nickName;
        }
        if (headImgUrl != null) {
            this.headImgUrl = headImgUrl;
        }
        if (sex != null) {
            this.sex = sex;
        }
        if (city != null) {
            this.city = city;
        }
        if (province != null) {
            this.province = province;
        }
        if (country != null) {
            this.country = country;
        }
        if (language != null) {
            this.language = language;
        }
    }
    
    /**
     * 设置备注
     */
    public void setUserRemark(String remark) {
        this.remark = remark;
    }
    
    /**
     * 设置标签
     */
    public void setUserTag(String wechatTagId) {
        this.wechatTagId = wechatTagId;
    }
}