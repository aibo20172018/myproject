package com.zn;

import Entity.ErrorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * 全局異常處理　只拋出yichang
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private static Long DUPLICATE_KEY_CODE = 1001L;
    private static Long PARAM_FAIL_CODE = 1002L;
    private static Long VALIDATION_CODE = 1003L;

    /**
     * 处理自定义异常　
     */
    /*@ExceptionHandler(BizException.class)
    public RspDTO handleRRException(BizException e) {
        logger.error(e.getMessage(), e);
        return new RspDTO(e.getCode(), e.getMessage());·
    }*/

    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(e.getMessage(), e);
        return new ErrorDTO(PARAM_FAIL_CODE, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public ErrorDTO handleValidationException(ValidationException e) {
        logger.error(e.getMessage(), e);
        return new ErrorDTO(VALIDATION_CODE, e.getCause().getMessage());
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorDTO handleConstraintViolationException(ConstraintViolationException e) {
        logger.error(e.getMessage(), e);
        return new ErrorDTO(PARAM_FAIL_CODE, e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ErrorDTO handlerNoFoundException(Exception e) {
        logger.error(e.getMessage(), e);
        return new ErrorDTO(404L, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ErrorDTO handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return new ErrorDTO(DUPLICATE_KEY_CODE, "数据重复，请检查后提交");
    }


    @ExceptionHandler(Exception.class)
    public ErrorDTO handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return new ErrorDTO(500L, "系统繁忙,请稍后再试");
    }
}
