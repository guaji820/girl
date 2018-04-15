package com.lify.util;

import com.lify.domain.ResponseData;

public class ResponseDataUtil {

    public static ResponseData success(Object obj){
        ResponseData responseData = new ResponseData();
        responseData.setCode(0);
        responseData.setMsg("成功");
        responseData.setData(obj);
        return responseData;
    }

    public static ResponseData success(){
        ResponseData responseData = new ResponseData();
        responseData.setCode(0);
        responseData.setMsg("成功");
        return responseData;
    }

    public static ResponseData fail(Integer code, String msg){
        ResponseData responseData = new ResponseData();
        responseData.setCode(code);
        responseData.setMsg(msg);
        return responseData;
    }

}
