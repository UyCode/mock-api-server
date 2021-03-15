package com.uycode.mockapiserver.common.exception;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ahmatjan(UyCode)
 * @email Hyper-Hack@outlook.com
 * @date 3/14/2021 16:19
 */

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 4346701645621328905L;
    private String code;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BusinessException() {
        this.code = "-1";
    }

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public String toJsonString() {
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("errno", this.code);
        returnMap.put("errmsg", super.getMessage());
        return JSON.toJSONString(returnMap);
    }

    public static void main(String[] args) {
        new BusinessException();
    }
}
