package com.mall.wechat.adapter.out.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.wechat.domain.model.menu.WechatMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微信菜单Mapper接口
 */
@Mapper
public interface WechatMenuMapper extends BaseMapper<WechatMenu> {
    
    /**
     * 根据父菜单ID查询子菜单
     */
    List<WechatMenu> findByParentId(@Param("parentId") Integer parentId);
    
    /**
     * 根据菜单状态查询菜单
     */
    List<WechatMenu> findByMenuState(@Param("menuState") Integer menuState);
}