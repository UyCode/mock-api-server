package com.uycode.mockapiserver.entity;


/**
 * @author ahmatjan(UyCode)
 * @email Hyper-Hack@outlook.com
 * @date 3/14/2021 17:14
 */


public class ResponseEntity<T> extends BaseEntity {

    private String code;

    private String message;

    private T data;

    public ResponseEntity() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
