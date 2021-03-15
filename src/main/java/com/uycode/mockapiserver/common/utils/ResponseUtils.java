package com.uycode.mockapiserver.common.utils;

import com.uycode.mockapiserver.common.exception.BusinessException;
import com.uycode.mockapiserver.common.exception.BusinessExceptionCode;
import com.uycode.mockapiserver.common.exception.MessageException;
import com.uycode.mockapiserver.entity.ResponseEntity;

/**
 * @author ahmatjan(UyCode)
 * @email Hyper-Hack@outlook.com
 * @date 3/14/2021 16:57
 */

public class ResponseUtils {
    private final static String DEFAULT_FAIL_CODE = "1";
    private final static String DEFAULT_SUCCESS_CODE = "0";

    public static <T> ResponseEntity<T> fail() {
        return fail(BusinessExceptionCode.FAIL.message());
    }

    public static <T> ResponseEntity<T> fail(String message) {
        throw new MessageException(message);
    }

    public static <T> ResponseEntity<T> fail(BusinessException exception) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setErrno(exception.getCode());
        responseEntity.setErrmsg(exception.getMessage());
        responseEntity.setData("");
        return responseEntity;
    }

    public static <T> ResponseEntity<T> success() {
        return success(BusinessExceptionCode.SUCCESS.message(), null);
    }

    public static <T> ResponseEntity<T> success(T t) {
        return success(BusinessExceptionCode.SUCCESS.message(), t);
    }

    public static <T> ResponseEntity<T> success(String message, T t) {
        ResponseEntity<T> result = new ResponseEntity<>();
        result.setErrno(DEFAULT_SUCCESS_CODE);
        result.setErrmsg(message);
        result.setData(t);

        return result;
    }

    public static <T> ResponseEntity<T> validResult(Boolean value) {
        return value ? success() : fail();
    }

    public static <T> ResponseEntity<T> validResult(Boolean value, String errorMessage) {
        return value ? success() : fail(errorMessage);
    }
}
