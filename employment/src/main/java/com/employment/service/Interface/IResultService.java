package com.employment.service.Interface;

import com.baomidou.framework.service.ISuperService;
import com.employment.bean.ResultBean;
import com.employment.bean.common.QueryParam;

import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public interface IResultService{

    List<ResultBean> countUniversity(QueryParam queryParam);

    List<ResultBean> countCollege(QueryParam queryParam);

    List<ResultBean> countMajor(QueryParam queryParam);

    List<ResultBean> countClassroom(QueryParam queryParam);
}
