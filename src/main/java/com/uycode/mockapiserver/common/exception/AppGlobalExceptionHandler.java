package com.uycode.mockapiserver.common.exception;

import com.uycode.mockapiserver.common.utils.ResponseUtils;
import com.uycode.mockapiserver.entity.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author ahmatjan(UyCode)
 * @email Hyper-Hack@outlook.com
 * @date 3/14/2021 16:15
 */

@ControllerAdvice
@Slf4j
public class AppGlobalExceptionHandler {

    @ExceptionHandler({VerificationException.class, NotFoundException.class, MessageException.class})
    @ResponseBody
    public ResponseEntity errorHandler(Exception exception) {
        BusinessException businessException = new BusinessException(BusinessExceptionCode.SYSTEM_INNER_ERROR.code(), exception.getMessage());

        if(exception instanceof VerificationException) {
            businessException = new BusinessException(BusinessExceptionCode.PARAM_IS_INVALID.code(),exception.getMessage());
        }

        if(exception instanceof NotFoundException) {
            businessException = new BusinessException(BusinessExceptionCode.DATA_NONE.code(), exception.getMessage());
        }

        if(exception instanceof MessageException) {
            businessException = new BusinessException(BusinessExceptionCode.FAIL.code(), exception.getMessage());
        }

        log.error(exception.getMessage());

        return ResponseUtils.fail(businessException);
    }
}
