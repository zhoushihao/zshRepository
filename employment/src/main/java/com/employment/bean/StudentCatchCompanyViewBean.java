package com.employment.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.employment.bean.common.BaseModel;

import java.io.Serializable;

/**
 * Created by apple on 2017-3-14.
 */
@TableName("v_student_catch_company_view")
public class StudentCatchCompanyViewBean extends BaseModel implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String student_id;//学生主键
    private String student_number;//学号
    private String student_name;//学生姓名
    private String university_name;//学校名字
    private String college_name;//学院名字
    private String major_name;//专业名字
    private String classroom_number;//班级编号
    private String company_name;//公司名字
    private String company_address;//公司地址

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public String getClassroom_number() {
        return classroom_number;
    }

    public void setClassroom_number(String classroom_number) {
        this.classroom_number = classroom_number;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }
}
