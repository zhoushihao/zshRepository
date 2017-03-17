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
@TableName("t_university")
public class UniversityBean extends BaseModel implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String university_id;
    private String university_number;
    private String university_name;
//    private String jurisdiction;

    @TableField(exist = false)
    public List<CollegeBean> colleges;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<CollegeBean> getColleges() {
        return colleges;
    }

    public void setColleges(List<CollegeBean> colleges) {
        this.colleges = colleges;
    }

    public String getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(String university_id) {
        this.university_id = university_id;
    }

    public String getUniversity_number() {
        return university_number;
    }

    public void setUniversity_number(String university_number) {
        this.university_number = university_number;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

}
