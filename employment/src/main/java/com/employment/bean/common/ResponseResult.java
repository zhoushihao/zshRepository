package com.employment.bean.common;

/**
 * Created by apple on 2017-2-21.
 */
public class ResponseResult {
    public static String SUCCESS = "success";
    public static String INFO = "info";
    public static String WARNING = "warning";
    public static String ERROR = "error";
    public static String VALIDTYPE = "valid";
    public static String VALIDDESCRIPTION = "校验失败";
    public static String EXCEPTIONTYPE = "exception";
    public static String EXCEPTIONTITLE = "异常错误";
    public static String POSTTYPE = "post";
    public static String DELETETYPE = "delete";
    public static String QUERYTYPE = "query";
    private String type;
    private String state;
    private String description;
    private Object data;

    public ResponseResult(String type, String state, String description, Object data) {
        this.state = state;
        this.description = description;
        this.data = data;
        this.type = type;
    }

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public static void setSUCCESS(String sUCCESS) {
        SUCCESS = sUCCESS;
    }

    public static String getINFO() {
        return INFO;
    }

    public static void setINFO(String iNFO) {
        INFO = iNFO;
    }

    public static String getWARNING() {
        return WARNING;
    }

    public static void setWARNING(String wARNING) {
        WARNING = wARNING;
    }

    public static String getERROR() {
        return ERROR;
    }

    public static void setERROR(String eRROR) {
        ERROR = eRROR;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
