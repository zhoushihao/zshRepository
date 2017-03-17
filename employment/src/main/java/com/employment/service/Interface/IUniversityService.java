package com.employment.service.Interface;

import com.baomidou.framework.service.ISuperService;
import com.employment.bean.UniversityBean;
import com.employment.bean.common.QueryParam;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public interface IUniversityService extends ISuperService<UniversityBean>{

    List<UniversityBean> selectUniversities(QueryParam queryParam);

    HashMap<String,UniversityBean> selectUniversityMap(QueryParam queryParam);
}
