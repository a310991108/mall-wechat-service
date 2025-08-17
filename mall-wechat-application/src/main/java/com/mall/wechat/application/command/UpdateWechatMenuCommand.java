package com.mall.wechat.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

/**
 * 更新微信菜单命令
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWechatMenuCommand {
    
    @NotNull(message = "菜单ID不能为空")
    private Long menuId;
    
    private String menuName;
    
    private String menuType;
    
    private Integer menuSort;
    
    private String menuKey;
    
    private String clickMsgType;
    
    private String menuReplyData;
    
    private String menuViewUrl;
    
    private Integer menuState;
}