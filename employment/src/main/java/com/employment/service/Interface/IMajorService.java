package com.employment.service.Interface;

import com.baomidou.framework.service.ISuperService;
import com.employment.bean.MajorBean;
import com.employment.bean.common.QueryParam;

import java.util.Dictionary;
import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public interface IMajorService extends ISuperService<MajorBean>{

    List<MajorBean> selectMajors(QueryParam queryParam);

    Dictionary<String,MajorBean> selectMajorMap(QueryParam queryParam);
}
