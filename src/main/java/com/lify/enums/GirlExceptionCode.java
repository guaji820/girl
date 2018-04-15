package com.lify.enums;

public enum GirlExceptionCode {
    EXCEPTION_CODE1(100, "没有找到对应女孩"),
    EXCEPTION_CODE2(101, "哼，小学生！！！"),
    EXCEPTION_CODE3(102, "哼，初中生！！！");

    private Integer code;
    private String msg;

    GirlExceptionCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
