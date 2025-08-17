package com.mall.wechat.adapter.out.persistence.repository;

import com.mall.wechat.adapter.out.persistence.mapper.WechatMenuMapper;
import com.mall.wechat.application.port.out.WechatMenuRepository;
import com.mall.wechat.domain.model.menu.WechatMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 微信菜单仓储实现
 */
@Repository
@RequiredArgsConstructor
public class WechatMenuRepositoryImpl implements WechatMenuRepository {
    
    private final WechatMenuMapper wechatMenuMapper;
    
    @Override
    public WechatMenu save(WechatMenu wechatMenu) {
        if (wechatMenu.getMenuId() == null) {
            wechatMenuMapper.insert(wechatMenu);
        } else {
            wechatMenuMapper.updateById(wechatMenu);
        }
        return wechatMenu;
    }
    
    @Override
    public Optional<WechatMenu> findById(Long menuId) {
        WechatMenu wechatMenu = wechatMenuMapper.selectById(menuId);
        return Optional.ofNullable(wechatMenu);
    }
    
    @Override
    public List<WechatMenu> findAll() {
        return wechatMenuMapper.selectList(null);
    }
    
    @Override
    public List<WechatMenu> findByParentId(Integer parentId) {
        return wechatMenuMapper.findByParentId(parentId);
    }
    
    @Override
    public List<WechatMenu> findByMenuState(Integer menuState) {
        return wechatMenuMapper.findByMenuState(menuState);
    }
    
    @Override
    public void deleteById(Long menuId) {
        wechatMenuMapper.deleteById(menuId);
    }
}