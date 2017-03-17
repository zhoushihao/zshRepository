package com.employment.bean.common;

import org.apache.taglibs.standard.resources.Resources;

/**
 * Created by apple on 2017-2-17.
 */
public enum HttpCode {
    OK(Integer.valueOf(200)),
    MULTI_STATUS(Integer.valueOf(207)),
    LOGIN_FAIL(Integer.valueOf(303)),
    BAD_REQUEST(Integer.valueOf(400)),
    UNAUTHORIZED(Integer.valueOf(401)),
    FORBIDDEN(Integer.valueOf(403)),
    NOT_FOUND(Integer.valueOf(404)),
    REQUEST_TIMEOUT(Integer.valueOf(408)),
    CONFLICT(Integer.valueOf(409)),
    GONE(Integer.valueOf(410)),
    LOCKED(Integer.valueOf(423)),
    INTERNAL_SERVER_ERROR(Integer.valueOf(500));

    private final Integer value;

    private HttpCode(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }

    public String msg() {
        return Resources.getMessage("HTTPCODE_" + this.value, new Object[0]);
    }

    public String toString() {
        return this.value.toString();
    }
}
