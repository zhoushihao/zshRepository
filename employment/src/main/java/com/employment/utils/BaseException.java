package com.employment.utils;

import com.employment.bean.common.HttpCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;

/**
 * Created by apple on 2017-2-17.
 */
public abstract class BaseException extends RuntimeException{
    public BaseException() {
    }

    public BaseException(Throwable ex) {
        super(ex);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable ex) {
        super(message, ex);
    }

    public void handler(ModelMap modelMap) {
        modelMap.put("httpCode", this.getHttpCode().value());
        if(StringUtils.isNotBlank(this.getMessage())) {
            modelMap.put("msg", this.getMessage());
        } else {
            modelMap.put("msg", this.getHttpCode().msg());
        }

        modelMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
    }

    protected abstract HttpCode getHttpCode();
}
