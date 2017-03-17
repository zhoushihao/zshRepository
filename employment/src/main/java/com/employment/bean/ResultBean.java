package com.employment.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.employment.bean.common.BaseModel;

import java.io.Serializable;

/**
 * Created by apple on 2017-2-17.
 */
public class ResultBean extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String university_id;
    private String college_id;
    private String major_id;
    private String classroom_id;

    private String university_student_amount;//大学学生总人数
    private String college_student_amount;//学院总人数
    private String major_student_amount;//专业总人数
    private String classroom_student_amount;//教室总人数
    private String job_amount;//就业总人数
    private String job_proportion;//就业率

    private String university_number;
    private String university_name;
    private String college_number;
    private String college_name;
    private String major_number;
    private String major_name;
    private String classroom_number;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUniversity_number() {
        return university_number;
    }

    public void setUniversity_number(String university_number) {
        this.university_number = university_number;
    }

    public String getCollege_number() {
        return college_number;
    }

    public void setCollege_number(String college_number) {
        this.college_number = college_number;
    }

    public String getMajor_number() {
        return major_number;
    }

    public void setMajor_number(String major_number) {
        this.major_number = major_number;
    }

    public String getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(String university_id) {
        this.university_id = university_id;
    }

    public String getCollege_id() {
        return college_id;
    }

    public void setCollege_id(String college_id) {
        this.college_id = college_id;
    }

    public String getMajor_id() {
        return major_id;
    }

    public void setMajor_id(String major_id) {
        this.major_id = major_id;
    }

    public String getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(String classroom_id) {
        this.classroom_id = classroom_id;
    }

    public String getUniversity_student_amount() {
        return university_student_amount;
    }

    public void setUniversity_student_amount(String university_student_amount) {
        this.university_student_amount = university_student_amount;
    }

    public String getCollege_student_amount() {
        return college_student_amount;
    }

    public void setCollege_student_amount(String college_student_amount) {
        this.college_student_amount = college_student_amount;
    }

    public String getMajor_student_amount() {
        return major_student_amount;
    }

    public void setMajor_student_amount(String major_student_amount) {
        this.major_student_amount = major_student_amount;
    }

    public String getClassroom_student_amount() {
        return classroom_student_amount;
    }

    public void setClassroom_student_amount(String classroom_student_amount) {
        this.classroom_student_amount = classroom_student_amount;
    }

    public String getJob_amount() {
        return job_amount;
    }

    public void setJob_amount(String job_amount) {
        this.job_amount = job_amount;
    }

    public String getJob_proportion() {
        return job_proportion;
    }

    public void setJob_proportion(String get_job_proportion) {
        this.job_proportion = get_job_proportion;
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
}
