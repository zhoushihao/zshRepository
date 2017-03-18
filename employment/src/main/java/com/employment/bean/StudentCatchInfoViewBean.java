package com.employment.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.employment.bean.common.BaseModel;

import java.io.Serializable;

/**
 * Created by apple on 2017-3-13.
 */
@TableName("v_student_catch_Info")
public class StudentCatchInfoViewBean extends BaseModel implements Serializable{
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String student_id;//学生主键
    private String university_id;
    private String college_id;//学院主键
    private String major_id;//专业主键
    private String classroom_id;//教室主键
    private String student_number;//学号
    private String student_name;//学生姓名
    private String id_card;//身份证
    private String native_place;//籍贯
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private String graduation_time;//毕业时间
    private String sex;//性别
    private String age;//年龄
    private String university_number;//学校编号
    private String university_name;//学校名字
    private String college_number;//学院编号
    private String college_name;//学院名字
    private String major_number;//专业编号
    private String major_name;//专业名字
    private String classroom_number;//班级编号
    private String company_name;
    private String company_address;
    private String manager;

    //
    private String person_amount;//人数
    private String job_amount;//就业人数

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
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

    public String getPerson_amount() {
        return person_amount;
    }

    public void setPerson_amount(String person_amount) {
        this.person_amount = person_amount;
    }

    public String getJob_amount() {
        return job_amount;
    }

    public void setJob_amount(String job_amount) {
        this.job_amount = job_amount;
    }


    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
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

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getGraduation_time() {
        return graduation_time;
    }

    public void setGraduation_time(String graduation_time) {
        this.graduation_time = graduation_time;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
