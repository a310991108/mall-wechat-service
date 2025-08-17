package com.mall.wechat.common.exception;

import com.mall.wechat.common.enums.Resp;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 业务异常类
 * 用于处理业务逻辑中的异常情况
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException {
    private Resp resp;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Resp resp) {
        super(resp.getMessage());
        this.resp = resp;
    }
}