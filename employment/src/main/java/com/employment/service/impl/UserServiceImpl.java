package com.employment.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.employment.bean.CollegeBean;
import com.employment.bean.UniversityBean;
import com.employment.bean.UserBean;
import com.employment.bean.VerifyCodeBean;
import com.employment.bean.common.QueryParam;
import com.employment.dao.UserDao;
import com.employment.service.Interface.IUniversityService;
import com.employment.service.Interface.IUserService;
import com.employment.service.support.BaseServiceImpl;
import com.employment.utils.QueryUtil;
import com.employment.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Created by apple on 2017-2-9.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, UserBean> implements IUserService {

    @Autowired
    IUniversityService universityService;

    //实现生成验证码
    public VerifyCodeBean createCode() {
        File dir = new File("./src/main/webapp/verifyCode");
        int w = 200, h = 80;
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        File file = new File(dir, verifyCode + ".jpg");
        try {
            System.out.println(verifyCode);
            VerifyCodeUtils.outputImage(w, h, file, verifyCode);
            VerifyCodeBean codeBean = new VerifyCodeBean();
            codeBean.setFilePath("./src/main/webapp/verifyCode/" + verifyCode + ".jpg");
            codeBean.setCode(verifyCode);
            return codeBean;
        } catch (Exception e) {
            throw new RuntimeException("验证码生成出错了");
        }
    }

    public UserBean checkLogin(UserBean entity) {
        UserBean user = selectOne(entity);
        return user;
    }

    public List<UniversityBean> queryUniversities(QueryParam queryParam) {
        return universityService.selectUniversities(queryParam);
    }

}
