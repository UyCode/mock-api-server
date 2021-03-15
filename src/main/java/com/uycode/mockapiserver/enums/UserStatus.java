package com.uycode.mockapiserver.enums;

public enum UserStatus {

    USER_STATUS_NORMAL(1),
    USER_STATUS_BANNED(0);


    private int statusCode;

    UserStatus(int i) {
        this.statusCode = i;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
