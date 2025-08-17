package com.mall.wechat.application.service;

import com.mall.wechat.application.command.CreateWechatUserCommand;
import com.mall.wechat.application.command.UpdateWechatUserCommand;
import com.mall.wechat.application.dto.WechatUserResponse;
import com.mall.wechat.application.port.in.WechatUserUseCase;
import com.mall.wechat.application.port.out.WechatUserRepository;
import com.mall.wechat.common.exception.BusinessException;
import com.mall.wechat.common.enums.Resp;
import com.mall.wechat.domain.model.wechatuser.WechatUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 微信用户应用服务
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WechatUserService implements WechatUserUseCase {
    
    private final WechatUserRepository wechatUserRepository;
    
    @Override
    @Transactional
    public WechatUserResponse createWechatUser(CreateWechatUserCommand command) {
        log.info("创建微信用户，OpenID: {}", command.getOpenId());
        
        // 检查OpenID是否已存在
        if (wechatUserRepository.existsByOpenId(command.getOpenId())) {
            throw new BusinessException(Resp.WECHAT_USER_ALREADY_EXISTS);
        }
        
        // 创建微信用户
        WechatUser wechatUser = WechatUser.create(
            command.getOpenId(),
            command.getNickName(),
            command.getSex(),
            command.getSubscribeTime()
        );
        
        // 设置其他属性
        wechatUser.updateUserInfo(
            command.getNickName(),
            command.getHeadImgUrl(),
            command.getSex(),
            command.getCity(),
            command.getProvince(),
            command.getCountry(),
            command.getLanguage()
        );
        
        if (command.getRemark() != null) {
            wechatUser.setUserRemark(command.getRemark());
        }
        
        if (command.getWechatTagId() != null) {
            wechatUser.setUserTag(command.getWechatTagId());
        }
        
        wechatUser.setUnionId(command.getUnionId());
        wechatUser.setGroupId(command.getGroupId());
        
        // 保存微信用户
        WechatUser savedUser = wechatUserRepository.save(wechatUser);
        
        log.info("微信用户创建成功，用户ID: {}", savedUser.getUserId());
        return convertToResponse(savedUser);
    }
    
    @Override
    @Transactional
    public WechatUserResponse updateWechatUser(UpdateWechatUserCommand command) {
        log.info("更新微信用户，用户ID: {}", command.getUserId());
        
        WechatUser wechatUser = wechatUserRepository.findById(command.getUserId())
            .orElseThrow(() -> new BusinessException(Resp.WECHAT_USER_NOT_FOUND));
        
        // 更新用户信息
        wechatUser.updateUserInfo(
            command.getNickName(),
            command.getHeadImgUrl(),
            command.getSex(),
            command.getCity(),
            command.getProvince(),
            command.getCountry(),
            command.getLanguage()
        );
        
        if (command.getRemark() != null) {
            wechatUser.setUserRemark(command.getRemark());
        }
        
        if (command.getWechatTagId() != null) {
            wechatUser.setUserTag(command.getWechatTagId());
        }
        
        wechatUser.setGroupId(command.getGroupId());
        
        // 保存更新
        WechatUser savedUser = wechatUserRepository.save(wechatUser);
        
        log.info("微信用户更新成功，用户ID: {}", savedUser.getUserId());
        return convertToResponse(savedUser);
    }
    
    @Override
    public WechatUserResponse getWechatUserByOpenId(String openId) {
        log.info("根据OpenID查询微信用户: {}", openId);
        
        WechatUser wechatUser = wechatUserRepository.findByOpenId(openId)
            .orElseThrow(() -> new BusinessException(Resp.WECHAT_USER_NOT_FOUND));
        
        return convertToResponse(wechatUser);
    }
    
    @Override
    public WechatUserResponse getWechatUserById(Long userId) {
        log.info("根据ID查询微信用户: {}", userId);
        
        WechatUser wechatUser = wechatUserRepository.findById(userId)
            .orElseThrow(() -> new BusinessException(Resp.WECHAT_USER_NOT_FOUND));
        
        return convertToResponse(wechatUser);
    }
    
    @Override
    public List<WechatUserResponse> getAllWechatUsers() {
        log.info("查询所有微信用户");
        
        List<WechatUser> wechatUsers = wechatUserRepository.findAll();
        return wechatUsers.stream()
            .map(this::convertToResponse)
            .collect(Collectors.toList());
    }
    
    @Override
    @Transactional
    public void deleteWechatUser(Long userId) {
        log.info("删除微信用户，用户ID: {}", userId);
        
        if (!wechatUserRepository.findById(userId).isPresent()) {
            throw new BusinessException(Resp.WECHAT_USER_NOT_FOUND);
        }
        
        wechatUserRepository.deleteById(userId);
        log.info("微信用户删除成功，用户ID: {}", userId);
    }
    
    /**
     * 转换为响应DTO
     */
    private WechatUserResponse convertToResponse(WechatUser wechatUser) {
        WechatUserResponse response = new WechatUserResponse();
        response.setUserId(wechatUser.getUserId());
        response.setCity(wechatUser.getCity());
        response.setCountry(wechatUser.getCountry());
        response.setGroupId(wechatUser.getGroupId());
        response.setHeadImgUrl(wechatUser.getHeadImgUrl());
        response.setLanguage(wechatUser.getLanguage());
        response.setNickName(wechatUser.getNickName());
        response.setOpenId(wechatUser.getOpenId());
        response.setProvince(wechatUser.getProvince());
        response.setRemark(wechatUser.getRemark());
        response.setSex(wechatUser.getSex());
        response.setSubscribeTime(wechatUser.getSubscribeTime());
        response.setUnionId(wechatUser.getUnionId());
        response.setWechatTagId(wechatUser.getWechatTagId());
        response.setCreatedAt(wechatUser.getCreatedAt());
        response.setUpdatedAt(wechatUser.getUpdatedAt());
        return response;
    }
}