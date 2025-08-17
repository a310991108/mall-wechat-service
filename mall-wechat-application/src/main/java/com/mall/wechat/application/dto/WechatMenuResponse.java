package com.mall.wechat.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 微信菜单响应DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WechatMenuResponse {
    
    private Long menuId;
    
    private String clickMsgType;
    
    private String menuKey;
    
    private String menuName;
    
    private String menuReplyData;
    
    private Integer menuSort;
    
    private Integer menuState;
    
    private String menuType;
    
    private String menuViewUrl;
    
    private Integer parentId;
    
    private String parentName;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}