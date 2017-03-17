package com.employment.bean.common;

import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * Created by apple on 2017-2-9.
 */
public class WhereParam implements Serializable {
    @TableField(
            exist = false
    )
    private static final long serialVersionUID = 1L;
    private String field;
    private String operate;
    private String value;

    public WhereParam() {
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOperate() {
        return this.operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static long getSerialVersionUID() {
        return 1L;
    }
}
