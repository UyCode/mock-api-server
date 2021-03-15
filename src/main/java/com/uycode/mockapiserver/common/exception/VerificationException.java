package com.uycode.mockapiserver.common.exception;

/**
 * @author ahmatjan(UyCode)
 * @email Hyper-Hack@outlook.com
 * @date 3/14/2021 16:14
 */

public class VerificationException extends RuntimeException {

    public VerificationException(String message) {
        super(message);
    }

    public VerificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
