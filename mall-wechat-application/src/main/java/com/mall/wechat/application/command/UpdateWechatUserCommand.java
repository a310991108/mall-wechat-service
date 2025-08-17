package com.mall.wechat.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

/**
 * 更新微信用户命令
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWechatUserCommand {
    
    @NotNull(message = "用户ID不能为空")
    private Long userId;
    
    private String nickName;
    
    private Integer sex;
    
    private String headImgUrl;
    
    private String city;
    
    private String province;
    
    private String country;
    
    private String language;
    
    private String remark;
    
    private String wechatTagId;
    
    private Integer groupId;
}