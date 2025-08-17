package com.mall.wechat.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * 创建微信菜单命令
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateWechatMenuCommand {
    
    @NotBlank(message = "菜单名称不能为空")
    private String menuName;
    
    @NotBlank(message = "菜单类型不能为空")
    private String menuType;
    
    private Integer parentId;
    
    private Integer menuSort;
    
    private String menuKey;
    
    private String clickMsgType;
    
    private String menuReplyData;
    
    private String menuViewUrl;
    
    private String parentName;
}