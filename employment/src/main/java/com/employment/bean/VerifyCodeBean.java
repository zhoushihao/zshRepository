package com.employment.bean;

import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * Created by apple on 2017-3-6.
 */
public class VerifyCodeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String filePath;
    private String code;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
