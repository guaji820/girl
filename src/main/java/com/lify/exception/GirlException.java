package com.lify.exception;

import com.lify.enums.GirlExceptionCode;

public class GirlException extends CommonException {

    private Integer code;

    public GirlException(GirlExceptionCode girlExceptionCode) {
        super(girlExceptionCode.getCode(), girlExceptionCode.getMsg());
    }
}
