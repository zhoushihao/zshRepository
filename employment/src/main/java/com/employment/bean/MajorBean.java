package com.employment.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.employment.bean.common.BaseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017-2-17.
 */
@TableName("t_major")
public class MajorBean extends BaseModel implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String major_id;
    private String college_id;
    private String major_number;
    private String major_name;

    @TableField
    private List<ClassroomBean> classroomList;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<ClassroomBean> getClassroomList() {
        return classroomList;
    }

    public void setClassroomList(List<ClassroomBean> classroomList) {
        this.classroomList = classroomList;
    }

    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public String getCollege_id() {
        return college_id;
    }

    public void setCollege_id(String college_id) {
        this.college_id = college_id;
    }

    public String getMajor_number() {
        return major_number;
    }

    public void setMajor_number(String major_number) {
        this.major_number = major_number;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }
}
