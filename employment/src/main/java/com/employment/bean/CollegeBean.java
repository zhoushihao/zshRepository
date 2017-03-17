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
@TableName("t_college")
public class CollegeBean extends BaseModel implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String college_id;
    private String university_id;
    private String college_number;
    private String college_name;

    @TableField(exist = false)
    private List<MajorBean> majors;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<MajorBean> getMajors() {
        return majors;
    }

    public void setMajors(List<MajorBean> majors) {
        this.majors = majors;
    }

    public String getCollege_id() {
        return college_id;
    }

    public void setCollege_id(String college_id) {
        this.college_id = college_id;
    }

    public String getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(String university_id) {
        this.university_id = university_id;
    }

    public String getCollege_number() {
        return college_number;
    }

    public void setCollege_number(String college_number) {
        this.college_number = college_number;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }
}
