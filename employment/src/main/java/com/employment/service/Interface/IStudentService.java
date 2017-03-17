package com.employment.service.Interface;

import com.baomidou.framework.service.ISuperService;
import com.employment.bean.StudentBean;
import com.employment.bean.StudentCatchInfoViewBean;
import com.employment.bean.common.QueryParam;

import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public interface IStudentService extends ISuperService<StudentBean>{

    List<StudentCatchInfoViewBean> queryStudents(QueryParam queryParam);

    boolean updateStudent(StudentBean bean);

    boolean insertStudent(StudentBean bean);

    boolean deleteStudent(List<StudentBean> list);
}
