package com.mall.wechat.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 微信用户响应DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WechatUserResponse {
    
    private Long userId;
    
    private String city;
    
    private String country;
    
    private Integer groupId;
    
    private String headImgUrl;
    
    private String language;
    
    private String nickName;
    
    private String openId;
    
    private String province;
    
    private String remark;
    
    private Integer sex;
    
    private LocalDateTime subscribeTime;
    
    private String unionId;
    
    private String wechatTagId;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}