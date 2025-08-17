package com.mall.wechat.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * 创建微信用户命令
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateWechatUserCommand {
    
    @NotBlank(message = "OpenID不能为空")
    private String openId;
    
    @NotBlank(message = "昵称不能为空")
    private String nickName;
    
    private Integer sex;
    
    private String headImgUrl;
    
    private String city;
    
    private String province;
    
    private String country;
    
    private String language;
    
    private String unionId;
    
    private LocalDateTime subscribeTime;
    
    private String remark;
    
    private String wechatTagId;
    
    private Integer groupId;
}