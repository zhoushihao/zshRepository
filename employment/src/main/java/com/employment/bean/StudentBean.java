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
@TableName("t_student")
public class StudentBean extends BaseModel implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId
    private String student_id;//学生主键
    private String student_number;//学号
    private String student_name;//学生姓名
    private String id_card;//身份证
    private String native_place;//籍贯
    private String university_id;//学校主键
    private String college_id;//学院主键
    private String major_id;//专业主键
    private String classroom_id;//教室主键
    private String company_id;
    @JSONField(format = "yyyy-MM-dd")
    private Date graduation_time;//毕业时间
    private String sex;//性别
    private String age;//年龄

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(String classroom_id) {
        this.classroom_id = classroom_id;
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

    public Date getGraduation_time() {
        return graduation_time;
    }

    public void setGraduation_time(Date graduation_time) {
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
}
