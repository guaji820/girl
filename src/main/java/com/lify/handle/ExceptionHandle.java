package com.lify.handle;

import com.lify.domain.ResponseData;
import com.lify.exception.CommonException;
import com.lify.util.ResponseDataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData handle(Exception e) {
        if (e instanceof CommonException) {
            return ResponseDataUtil.fail(((CommonException) e).getCode(), ((CommonException) e).getMessage());
        }
        logger.info("系统异常{}", e);
        return ResponseDataUtil.fail(-1, e.getMessage());
    }
}
