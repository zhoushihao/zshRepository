package com.employment.service.Interface;

import com.baomidou.framework.service.ISuperService;
import com.employment.bean.CollegeBean;
import com.employment.bean.UniversityBean;
import com.employment.bean.UserBean;
import com.employment.bean.VerifyCodeBean;
import com.employment.bean.common.QueryParam;

import java.util.HashMap;
import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public interface IUserService extends ISuperService<UserBean>{

    //生成验证码
    VerifyCodeBean createCode ();

    //验证登陆
    UserBean checkLogin(UserBean userBean);

    //查询学校
    List<UniversityBean> queryUniversities(QueryParam queryParam);

    List<UserBean> isExsit(UserBean user);
}
