package com.employment.service.Interface;

import com.baomidou.framework.service.ISuperService;
import com.employment.bean.CollegeBean;
import com.employment.bean.common.QueryParam;

import java.util.Dictionary;
import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public interface ICollegeService extends ISuperService<CollegeBean>{

    /*
    查询学院
     */
    List<CollegeBean> selectAllColleges(QueryParam queryParam);

    Dictionary<String,CollegeBean> selectCollegeMap(QueryParam queryParam);
}
