package com.uycode.mockapiserver.common.exception;

/**
 * @author ahmatjan(UyCode)
 * @email Hyper-Hack@outlook.com
 * @date 3/14/2021 16:44
 */


public class SystemBusinessException extends BusinessException {
    public SystemBusinessException(BusinessExceptionCode BusinessExceptionCode) {
        super(BusinessExceptionCode.code(), BusinessExceptionCode.message());
    }
}