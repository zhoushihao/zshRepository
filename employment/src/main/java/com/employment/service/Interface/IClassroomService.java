package com.employment.service.Interface;

import com.baomidou.framework.service.ISuperService;
import com.employment.bean.ClassroomBean;
import com.employment.bean.common.QueryParam;

import java.util.Dictionary;
import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public interface IClassroomService extends ISuperService<ClassroomBean>{

    /*
    查询班级
     */
    List<ClassroomBean> selectAllClassrooms(QueryParam queryParam);

    Dictionary<String,ClassroomBean> selectClassroomMap(QueryParam queryParam);
}
