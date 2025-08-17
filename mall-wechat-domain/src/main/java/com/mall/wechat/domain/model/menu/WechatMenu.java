package com.mall.wechat.domain.model.menu;

import com.baomidou.mybatisplus.annotation.*;
import com.mall.wechat.common.exception.BusinessException;
import com.mall.wechat.common.enums.Resp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 微信菜单领域实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("wechat_menu")
public class WechatMenu {
    
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;
    
    /**
     * 点击消息类型
     */
    private String clickMsgType;
    
    /**
     * 菜单KEY值
     */
    private String menuKey;
    
    /**
     * 菜单名称
     */
    private String menuName;
    
    /**
     * 菜单回复数据
     */
    private String menuReplyData;
    
    /**
     * 菜单排序
     */
    private Integer menuSort;
    
    /**
     * 菜单状态：0-禁用，1-启用
     */
    private Integer menuState;
    
    /**
     * 菜单类型：click-点击，view-跳转URL
     */
    private String menuType;
    
    /**
     * 菜单跳转URL
     */
    private String menuViewUrl;
    
    /**
     * 父菜单ID
     */
    private Integer parentId;
    
    /**
     * 父菜单名称
     */
    private String parentName;
    
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
     * 创建菜单
     */
    public static WechatMenu create(String menuName, String menuType, Integer parentId, Integer menuSort) {
        if (menuName == null || menuName.trim().isEmpty()) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        if (menuType == null || menuType.trim().isEmpty()) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        
        // 验证菜单类型
        if (!"click".equals(menuType) && !"view".equals(menuType)) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        
        WechatMenu menu = new WechatMenu();
        menu.setMenuName(menuName);
        menu.setMenuType(menuType);
        menu.setParentId(parentId != null ? parentId : 0);
        menu.setMenuSort(menuSort != null ? menuSort : 0);
        menu.setMenuState(1); // 默认启用
        return menu;
    }
    
    /**
     * 设置点击菜单
     */
    public void setClickMenu(String menuKey, String clickMsgType, String menuReplyData) {
        if (!"click".equals(this.menuType)) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        this.menuKey = menuKey;
        this.clickMsgType = clickMsgType;
        this.menuReplyData = menuReplyData;
    }
    
    /**
     * 设置跳转菜单
     */
    public void setViewMenu(String menuViewUrl) {
        if (!"view".equals(this.menuType)) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        if (menuViewUrl == null || menuViewUrl.trim().isEmpty()) {
            throw new BusinessException(Resp.INVALID_PARAM);
        }
        this.menuViewUrl = menuViewUrl;
    }
    
    /**
     * 启用菜单
     */
    public void enable() {
        this.menuState = 1;
    }
    
    /**
     * 禁用菜单
     */
    public void disable() {
        this.menuState = 0;
    }
    
    /**
     * 判断是否为根菜单
     */
    public boolean isRootMenu() {
        return this.parentId == null || this.parentId == 0;
    }
}