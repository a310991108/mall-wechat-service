package com.mall.wechat.application.port.in;

import com.mall.wechat.application.command.CreateWechatMenuCommand;
import com.mall.wechat.application.command.UpdateWechatMenuCommand;
import com.mall.wechat.application.dto.WechatMenuResponse;

import java.util.List;

/**
 * 微信菜单用例接口
 */
public interface WechatMenuUseCase {

    /**
     * 创建微信菜单
     */
    WechatMenuResponse createWechatMenu(CreateWechatMenuCommand command);
    
    /**
     * 更新微信菜单
     */
    WechatMenuResponse updateWechatMenu(Long menuId, UpdateWechatMenuCommand command);

    /**
     * 根据ID查询微信菜单
     */
    WechatMenuResponse getWechatMenuById(Long menuId);
    
    /**
     * 查询所有微信菜单
     */
    List<WechatMenuResponse> getAllWechatMenus();
    
    /**
     * 根据父菜单ID查询子菜单
     */
    List<WechatMenuResponse> getWechatMenusByParentId(Integer parentId);
    
    /**
     * 删除微信菜单
     */
    void deleteWechatMenu(Long menuId);
    
    /**
     * 启用微信菜单
     */
    void enableWechatMenu(Long menuId);
    
    /**
     * 禁用微信菜单
     */
    void disableWechatMenu(Long menuId);

    /**
     * 根据菜单状态查询菜单列表
     */
    List<WechatMenuResponse> getWechatMenusByState(Integer menuState);
}