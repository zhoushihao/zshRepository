package com.employment.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.employment.bean.*;
import com.employment.bean.common.QueryParam;
import com.employment.dao.StudentDao;
import com.employment.service.Interface.*;
import com.employment.service.support.BaseServiceImpl;
import com.employment.utils.BeanUtil;
import com.employment.utils.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Dictionary;
import java.util.List;


/**
 * Created by apple on 2017-2-9.
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentDao,StudentBean> implements IStudentService {

    @Autowired
    IUniversityService universityService;
    @Autowired
    ICollegeService collegeService;
    @Autowired
    IMajorService majorService;
    @Autowired
    IClassroomService classroomService;
    @Autowired
    IStudentCatchInfoViewService studentViewService;

    public List<StudentCatchInfoViewBean> queryStudents(QueryParam queryParam) {
        List<StudentCatchInfoViewBean> list = studentViewService.selectStudents(queryParam);
        return list;
    }

    public boolean updateStudent(StudentBean bean){
        String[] include = {"student_number" ,"student_name","id_card","native_place",
                             "university_id","college_id","major_id","classroom_id",
                             "graduation_time","sex","age"};
        StudentBean update = (StudentBean) BeanUtil.copyProperties(bean,new StudentBean(),include);
        StudentBean where = (StudentBean) BeanUtil.newBean(bean,new StudentBean());
        where.setStudent_id(bean.getStudent_id());
        updateSelective(update,where);
        return true;
    }

    public boolean insertStudent(StudentBean bean){
        bean.setInsert_date(new Date());
        insert(bean);
        return true;
    }

    public boolean deleteStudent(List<StudentBean> list) {
        for(StudentBean entity:list){
            StudentBean update = new StudentBean();
            update.setIs_del("Y");
            update.setDelete_date(new Date());
            StudentBean where = (StudentBean) BeanUtil.newBean(entity,new StudentBean());
            where.setStudent_id(entity.getStudent_id());
            updateSelective(update,where);
        }
        return true;
    }
}
