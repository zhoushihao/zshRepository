package com.employment.service.Interface;


import com.employment.bean.ClassroomBean;
import com.employment.bean.CollegeBean;
import com.employment.bean.MajorBean;
import com.employment.bean.UniversityBean;
import com.employment.bean.common.QueryParam;

import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public interface IConfigCenterService{

    List<UniversityBean> queryUniversity(QueryParam queryParam);

    List<CollegeBean> queryCollege(UniversityBean collegeBean);

    List<MajorBean> queryMajor(CollegeBean majorBean);

    List<ClassroomBean> queryClassroom(MajorBean classroomBean);

    boolean update(UniversityBean universityBean);

    boolean insert(UniversityBean universityBean);

    boolean deleteUniversity(List<UniversityBean> list);
}
