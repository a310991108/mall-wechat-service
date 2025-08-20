package com.mall.wechat.adapter.in.web.exception;

import com.mall.wechat.common.Result;
import com.mall.wechat.common.enums.Resp;
import com.mall.wechat.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> handleBusinessException(BusinessException e) {
        Resp resp = e.getResp();
        if (resp == null) {
            log.info("业务异常（无枚举）：{}", e.getMessage());
            return Result.fail(Result.HTTP_OK, "Wechat99000", e.getMessage(), null);
        }

        log.info("业务异常：{}", resp.getMessage());
        return Result.fail(Result.HTTP_OK, resp.getCode(), resp.getMessage(), null);
    }
    
    /**
     * 处理参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> handleValidationException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String errorMessage = fieldErrors.stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        log.info("参数校验失败: {}", errorMessage);

        // 收集详细的字段错误信息
        Map<String, Object> fieldErrorMap = new HashMap<>();
        fieldErrors.forEach(error ->
                fieldErrorMap.put(error.getField(), error.getDefaultMessage())
        );

        Result<Object> result = Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), errorMessage, null);
        result.setExtra(fieldErrorMap);
        return result;
    }
    
    /**
     * 处理绑定异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> handleBindException(BindException e) {
        String errorMessage = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        log.info("参数绑定失败: {}", errorMessage);
        return Result.fail(Result.HTTP_BAD_REQUEST, Resp.INVALID_PARAM.getCode(), errorMessage, null);
    }
    
    /**
     * 处理其他异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Void> handleException(Exception e) {
        log.error("系统异常", e);
        return Result.fail(Resp.SYSTEM_ERROR);
    }
}