package com.employment.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.employment.bean.common.BaseModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by apple on 2017-2-17.
 */
@TableName("t_user")
public class UserBean extends BaseModel implements  Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String user_id;
    private String user_number;
    private String user_name;
    private String user_password;

//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
//    private Date insert_date;
//
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss" )
//    private Date update_date;
//
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss" )
//    private Date delete_date;
//    private String is_del;
//    private String remark;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
