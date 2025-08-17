package com.mall.wechat.application.port.out;

import com.mall.wechat.domain.model.menu.WechatMenu;

import java.util.List;
import java.util.Optional;

/**
 * 微信菜单仓储接口
 */
public interface WechatMenuRepository {
    
    /**
     * 保存微信菜单
     */
    WechatMenu save(WechatMenu wechatMenu);
    
    /**
     * 根据ID查询微信菜单
     */
    Optional<WechatMenu> findById(Long menuId);
    
    /**
     * 查询所有微信菜单
     */
    List<WechatMenu> findAll();
    
    /**
     * 根据父菜单ID查询子菜单
     */
    List<WechatMenu> findByParentId(Integer parentId);
    
    /**
     * 根据菜单状态查询菜单
     */
    List<WechatMenu> findByMenuState(Integer menuState);
    
    /**
     * 删除微信菜单
     */
    void deleteById(Long menuId);
}