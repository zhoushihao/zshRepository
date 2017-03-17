package com.employment.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.employment.bean.StudentCatchInfoViewBean;
import com.employment.bean.common.QueryParam;
import com.employment.dao.StudentCatchInfoViewDao;
import com.employment.service.Interface.IStudentCatchInfoViewService;
import com.employment.service.support.BaseServiceImpl;
import com.employment.utils.BeanUtil;
import com.employment.utils.QueryUtil;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;


/**
 * Created by apple on 2017-2-9.
 */
@Service
public class StudentCatchInfoServiceImpl extends BaseServiceImpl<StudentCatchInfoViewDao,StudentCatchInfoViewBean> implements IStudentCatchInfoViewService {


    public List<StudentCatchInfoViewBean> selectStudents(QueryParam queryParam) {
        StudentCatchInfoViewBean bean = (StudentCatchInfoViewBean) BeanUtil.newBean(queryParam,new StudentCatchInfoViewBean());
        EntityWrapper<StudentCatchInfoViewBean> ew = new EntityWrapper<StudentCatchInfoViewBean>(bean);
        ew.orderBy("student_number");
        QueryUtil.initEntityWrapper(ew,queryParam);
        List<StudentCatchInfoViewBean> list = selectList(ew);
        return list;
    }
}
