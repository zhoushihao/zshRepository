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
@TableName("t_classroom")
public class ClassroomBean extends BaseModel implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String classroom_id;
    private String major_id;
    private String classroom_number;

    @TableField(exist = false)
    private List<StudentBean> students;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(String classroom_id) {
        this.classroom_id = classroom_id;
    }

    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public String getClassroom_number() {
        return classroom_number;
    }

    public void setClassroom_number(String classroom_number) {
        this.classroom_number = classroom_number;
    }

    public List<StudentBean> getStudents() {
        return students;
    }

    public void setStudents(List<StudentBean> students) {
        this.students = students;
    }
}
