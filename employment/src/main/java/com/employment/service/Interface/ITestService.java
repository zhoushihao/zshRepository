package com.employment.service.Interface;

import com.baomidou.framework.service.ISuperService;
import com.employment.bean.TestBean;
import com.employment.bean.common.QueryParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public interface ITestService extends ISuperService<TestBean>{
    List<TestBean> queryOrders(QueryParam queryParam);
}
