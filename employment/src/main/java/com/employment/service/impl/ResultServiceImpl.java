package com.employment.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.employment.bean.ResultBean;
import com.employment.bean.StudentCatchInfoViewBean;
import com.employment.bean.UniversityBean;
import com.employment.bean.common.QueryParam;
import com.employment.service.Interface.IResultService;
import com.employment.service.Interface.IStudentCatchInfoViewService;
import com.employment.service.Interface.IUniversityService;
import com.employment.utils.BeanUtil;
import com.employment.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;


/**
 * Created by apple on 2017-2-9.
 */
@Service
public class ResultServiceImpl implements IResultService {

    @Autowired
    IStudentCatchInfoViewService studentInfoService;
    @Autowired
    IUniversityService universityService;

    //对学校的统计
    public List<ResultBean> countUniversity(QueryParam queryParam) {
        //1.查询学校学生总人数
        StudentCatchInfoViewBean bean1 = (StudentCatchInfoViewBean) BeanUtil.newBean(queryParam,new StudentCatchInfoViewBean());
        EntityWrapper<StudentCatchInfoViewBean> ew1 = new EntityWrapper<StudentCatchInfoViewBean>(bean1);
        ew1.setSqlSelect("university_id,university_number,university_name,count(student_id) as person_amount");
        ew1.groupBy("university_id");
        QueryUtil.initEntityWrapper(ew1,queryParam);
        List<StudentCatchInfoViewBean> list1 = studentInfoService.selectList(ew1);
        HashMap<String,StudentCatchInfoViewBean> personMap = new HashMap<String, StudentCatchInfoViewBean>();
        for(StudentCatchInfoViewBean entity:list1){
            personMap.put(entity.getUniversity_id(),entity);
        }

        //2.查询就业学生人数
        StudentCatchInfoViewBean bean2 = (StudentCatchInfoViewBean) BeanUtil.newBean(queryParam,new StudentCatchInfoViewBean());
        EntityWrapper<StudentCatchInfoViewBean> ew2 = new EntityWrapper<StudentCatchInfoViewBean>(bean2);
        ew2.setSqlSelect("student_id,count(student_id) as job_amount");
        ew2.isNotNull("company_id");
        ew2.groupBy("university_id");
        QueryUtil.initEntityWrapper(ew2,queryParam);
        List<StudentCatchInfoViewBean> list2 = studentInfoService.selectList(ew2);
        HashMap<String,StudentCatchInfoViewBean> jobMap = new HashMap<String, StudentCatchInfoViewBean>();
        for (StudentCatchInfoViewBean entity:list2){
         jobMap.put(entity.getUniversity_id(),entity);
        }

        //以ResultBean的list返回
        List<ResultBean> resultList = new ArrayList<ResultBean>();
        for(String str:personMap.keySet()){
            StudentCatchInfoViewBean infoBean = personMap.get(str);
            BigDecimal people = new BigDecimal(infoBean.getPerson_amount());
            BigDecimal job = new BigDecimal(jobMap.get(str).getJob_amount());
            BigDecimal p = people.divide(job,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
            String proportion = p.toString()+"%";
            ResultBean bean = new ResultBean();
            bean.setUniversity_id(str);
            bean.setUniversity_number(infoBean.getUniversity_number());
            bean.setUniversity_name(infoBean.getUniversity_name());
            bean.setUniversity_student_amount(people.toString());
            bean.setJob_amount(job.toString());
            bean.setJob_proportion(proportion);
            resultList.add(bean);
        }
        return resultList;
    }

    //对学院的统计
    public List<ResultBean> countCollege(QueryParam queryParam) {
        //1.查询学院学生总人数
        StudentCatchInfoViewBean bean1 = (StudentCatchInfoViewBean) BeanUtil.newBean(queryParam,new StudentCatchInfoViewBean());
        EntityWrapper<StudentCatchInfoViewBean> ew1 = new EntityWrapper<StudentCatchInfoViewBean>(bean1);
        ew1.setSqlSelect("college_id,university_number,university_name,college_number,college_name,count(student_id) as person_amount");
        ew1.groupBy("college_id");
        QueryUtil.initEntityWrapper(ew1,queryParam);
        List<StudentCatchInfoViewBean> list1 = studentInfoService.selectList(ew1);
        HashMap<String,StudentCatchInfoViewBean> personMap = new HashMap<String, StudentCatchInfoViewBean>();
        for(StudentCatchInfoViewBean entity:list1){
            personMap.put(entity.getUniversity_id(),entity);
        }

        //2.查询就业学生人数
        StudentCatchInfoViewBean bean2 = (StudentCatchInfoViewBean) BeanUtil.newBean(queryParam,new StudentCatchInfoViewBean());
        EntityWrapper<StudentCatchInfoViewBean> ew2 = new EntityWrapper<StudentCatchInfoViewBean>(bean2);
        ew2.setSqlSelect("student_id,count(student_id) as job_amount");
        ew2.isNotNull("company_id");
        ew2.groupBy("college_id");
        QueryUtil.initEntityWrapper(ew2,queryParam);
        List<StudentCatchInfoViewBean> list2 = studentInfoService.selectList(ew2);
        HashMap<String,StudentCatchInfoViewBean> jobMap = new HashMap<String, StudentCatchInfoViewBean>();
        for (StudentCatchInfoViewBean entity:list2){
            jobMap.put(entity.getUniversity_id(),entity);
        }

        //以ResultBean的list返回
        List<ResultBean> resultList = new ArrayList<ResultBean>();
        for(String str:personMap.keySet()){
            StudentCatchInfoViewBean infoBean = personMap.get(str);
            BigDecimal people = new BigDecimal(infoBean.getPerson_amount());
            BigDecimal job = new BigDecimal(jobMap.get(str).getJob_amount());
            BigDecimal p = people.divide(job,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
            String proportion = p.toString()+"%";
            ResultBean bean = new ResultBean();
            bean.setCollege_id(infoBean.getCollege_id());
            bean.setUniversity_number(infoBean.getUniversity_number());
            bean.setUniversity_name(infoBean.getUniversity_name());
            bean.setCollege_number(infoBean.getCollege_number());
            bean.setCollege_name(infoBean.getCollege_name());
            bean.setUniversity_student_amount(people.toString());
            bean.setJob_amount(job.toString());
            bean.setJob_proportion(proportion);
            resultList.add(bean);
        }
        return resultList;
    }

    //对专业的统计
    public List<ResultBean> countMajor(QueryParam queryParam) {
        //1.查询专业学生总人数
        StudentCatchInfoViewBean bean1 = (StudentCatchInfoViewBean) BeanUtil.newBean(queryParam,new StudentCatchInfoViewBean());
        EntityWrapper<StudentCatchInfoViewBean> ew1 = new EntityWrapper<StudentCatchInfoViewBean>(bean1);
        ew1.setSqlSelect("major_id,university_number,university_name," +
                "college_number,college_name,major_number,major_name," +
                "count(student_id) as person_amount");
        ew1.groupBy("college_id");
        QueryUtil.initEntityWrapper(ew1,queryParam);
        List<StudentCatchInfoViewBean> list1 = studentInfoService.selectList(ew1);
        HashMap<String,StudentCatchInfoViewBean> personMap = new HashMap<String, StudentCatchInfoViewBean>();
        for(StudentCatchInfoViewBean entity:list1){
            personMap.put(entity.getUniversity_id(),entity);
        }

        //2.查询就业学生人数
        StudentCatchInfoViewBean bean2 = (StudentCatchInfoViewBean) BeanUtil.newBean(queryParam,new StudentCatchInfoViewBean());
        EntityWrapper<StudentCatchInfoViewBean> ew2 = new EntityWrapper<StudentCatchInfoViewBean>(bean2);
        ew2.setSqlSelect("student_id,count(student_id) as job_amount");
        ew2.isNotNull("company_id");
        ew2.groupBy("major_id");
        QueryUtil.initEntityWrapper(ew2,queryParam);
        List<StudentCatchInfoViewBean> list2 = studentInfoService.selectList(ew2);
        HashMap<String,StudentCatchInfoViewBean> jobMap = new HashMap<String, StudentCatchInfoViewBean>();
        for (StudentCatchInfoViewBean entity:list2){
            jobMap.put(entity.getUniversity_id(),entity);
        }

        //以ResultBean的list返回
        List<ResultBean> resultList = new ArrayList<ResultBean>();
        for(String str:personMap.keySet()){
            StudentCatchInfoViewBean infoBean = personMap.get(str);
            BigDecimal people = new BigDecimal(infoBean.getPerson_amount());
            BigDecimal job = new BigDecimal(jobMap.get(str).getJob_amount());
            BigDecimal p = people.divide(job,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
            String proportion = p.toString()+"%";
            ResultBean bean = new ResultBean();
            bean.setMajor_id(infoBean.getMajor_id());
            bean.setUniversity_number(infoBean.getUniversity_number());
            bean.setUniversity_name(infoBean.getUniversity_name());
            bean.setCollege_number(infoBean.getCollege_number());
            bean.setCollege_name(infoBean.getCollege_name());
            bean.setMajor_number(infoBean.getMajor_number());
            bean.setMajor_name(infoBean.getMajor_name());
            bean.setUniversity_student_amount(people.toString());
            bean.setJob_amount(job.toString());
            bean.setJob_proportion(proportion);
            resultList.add(bean);
        }
        return resultList;
    }

    //对教室的统计
    public List<ResultBean> countClassroom(QueryParam queryParam) {
        //1.查询班级学生总人数
        StudentCatchInfoViewBean bean1 = (StudentCatchInfoViewBean) BeanUtil.newBean(queryParam,new StudentCatchInfoViewBean());
        EntityWrapper<StudentCatchInfoViewBean> ew1 = new EntityWrapper<StudentCatchInfoViewBean>(bean1);
        ew1.setSqlSelect("classroom_id,university_number,university_name," +
                "college_number,college_name,major_number,major_name,,classroom_number" +
                "count(student_id) as person_amount");
        ew1.groupBy("classroom_id");
        QueryUtil.initEntityWrapper(ew1,queryParam);
        List<StudentCatchInfoViewBean> list1 = studentInfoService.selectList(ew1);
        HashMap<String,StudentCatchInfoViewBean> personMap = new HashMap<String, StudentCatchInfoViewBean>();
        for(StudentCatchInfoViewBean entity:list1){
            personMap.put(entity.getUniversity_id(),entity);
        }

        //2.查询就业学生人数
        StudentCatchInfoViewBean bean2 = (StudentCatchInfoViewBean) BeanUtil.newBean(queryParam,new StudentCatchInfoViewBean());
        EntityWrapper<StudentCatchInfoViewBean> ew2 = new EntityWrapper<StudentCatchInfoViewBean>(bean2);
        ew2.setSqlSelect("student_id,count(student_id) as job_amount");
        ew2.isNotNull("company_id");
        ew2.groupBy("major_id");
        QueryUtil.initEntityWrapper(ew2,queryParam);
        List<StudentCatchInfoViewBean> list2 = studentInfoService.selectList(ew2);
        HashMap<String,StudentCatchInfoViewBean> jobMap = new HashMap<String, StudentCatchInfoViewBean>();
        for (StudentCatchInfoViewBean entity:list2){
            jobMap.put(entity.getUniversity_id(),entity);
        }

        //以ResultBean的list返回
        List<ResultBean> resultList = new ArrayList<ResultBean>();
        for(String str:personMap.keySet()){
            StudentCatchInfoViewBean infoBean = personMap.get(str);
            BigDecimal people = new BigDecimal(infoBean.getPerson_amount());
            BigDecimal job = new BigDecimal(jobMap.get(str).getJob_amount());
            BigDecimal p = people.divide(job,4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
            String proportion = p.toString()+"%";
            ResultBean bean = new ResultBean();
            bean.setClassroom_id(infoBean.getClassroom_id());
            bean.setUniversity_number(infoBean.getUniversity_number());
            bean.setUniversity_name(infoBean.getUniversity_name());
            bean.setCollege_number(infoBean.getCollege_number());
            bean.setCollege_name(infoBean.getCollege_name());
            bean.setMajor_number(infoBean.getMajor_number());
            bean.setMajor_name(infoBean.getMajor_name());
            bean.setClassroom_number(infoBean.getClassroom_number());
            bean.setUniversity_student_amount(people.toString());
            bean.setJob_amount(job.toString());
            bean.setJob_proportion(proportion);
            resultList.add(bean);
        }
        return resultList;
    }
}
