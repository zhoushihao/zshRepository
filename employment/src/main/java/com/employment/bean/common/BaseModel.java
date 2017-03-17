package com.employment.bean.common;


import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by apple on 2017-2-9.
 */
public class BaseModel implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date insert_date;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss" )
    private Date update_date;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss" )
    private Date delete_date;

    private String user_id;
    private String is_del;
    private String remark;

    public BaseModel() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getDelete_date() {
        return delete_date;
    }

    public void setDelete_date(Date delete_date) {
        this.delete_date = delete_date;
    }

    public String getIs_del() {
        return is_del;
    }

    public void setIs_del(String is_del) {
        this.is_del = is_del;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
