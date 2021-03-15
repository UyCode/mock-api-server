package com.uycode.mockapiserver.common.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ahmatjan(UyCode)
 * @email Hyper-Hack@outlook.com
 * @date 3/14/2021 16:46
 */

public enum BusinessExceptionCode {

    /**
     * 常用异常枚举类
     */

    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    PARAM_IS_INVALID(11001, "参数无效"),
    PARAM_IS_BLANK(11002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(11003, "参数类型错误"),
    PARAM_NOT_COMPLETE(11004, "参数缺失"),
    ACCOUNT_UNLOGIN_ERROR(12001, "账户未登录或登录超时"),
    ACCOUNT_UNACCESS_ERROR(12002, "账户无访问权限"),
    ACCOUNT_AUTHDATA_ABSENCE_ERROR(12003, "认证数据缺失"),
    ACCOUNT_USER_AUTH_ERROR(12003, "认证失败,原因用户名密码错误。"),
    ACCOUNT_ACTIVATE_CHECK_ERROR(12004, "账户校验激活状态时获取登录失败记录异常"),
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),
    USER_ACCOUNT_FREEZED(20006, "用户已冻结"),
    MEMBER_NOT_EXIST(21001, "人员不存在"),
    ORG_HAS_MEMBER(23001, "机构存在人员，不允许删除"),
    RESOURCE_DATA_ERROR(13001, "资源树数据处理异常"),
    RESOURCE_NOT_EXIST(13002, "资源不存在异常"),
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),
    DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),
    PERMISSION_NO_ACCESS(70001, "无访问权限");

    private Integer code;
    private String message;

    private BusinessExceptionCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return String.valueOf(this.code);
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        BusinessExceptionCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            BusinessExceptionCode item = var1[var3];
            if (item.name().equals(name)) {
                return item.message;
            }
        }

        return name;
    }

    public static String getCode(String name) {
        BusinessExceptionCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            BusinessExceptionCode item = var1[var3];
            if (item.name().equals(name)) {
                return String.valueOf(item.code);
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

    public static void main(String[] args) {
        BusinessExceptionCode[] ApiResultCodes = values();
        List<String> codeList = new ArrayList();
        BusinessExceptionCode[] var3 = ApiResultCodes;
        int var4 = ApiResultCodes.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            BusinessExceptionCode ApiResultCode = var3[var5];
            if (codeList.contains(ApiResultCode.code)) {
                System.out.println(ApiResultCode.code);
            } else {
                System.out.println(ApiResultCode.code + "---" + getMessage(ApiResultCode.toString()));
                codeList.add(ApiResultCode.code());
            }
        }

    }
}