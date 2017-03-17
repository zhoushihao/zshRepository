package com.employment.service.Interface;

import com.baomidou.framework.service.ISuperService;
import com.employment.bean.StudentCatchInfoViewBean;
import com.employment.bean.common.QueryParam;

import java.util.List;

/**
 * Created by apple on 2017-3-14.
 */
public interface IStudentCatchInfoViewService extends ISuperService<StudentCatchInfoViewBean>{

    List<StudentCatchInfoViewBean> selectStudents(QueryParam queryParam);

}
