package com.employment.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.employment.bean.CollegeBean;
import com.employment.bean.UniversityBean;
import com.employment.bean.UserBean;
import com.employment.bean.VerifyCodeBean;
import com.employment.bean.common.QueryParam;
import com.employment.bean.common.ResponseResult;
import com.employment.controller.common.SysBaseController;
import com.employment.service.Interface.IUserService;
import com.employment.utils.BaseException;
import com.employment.utils.CookieUtils;
import com.employment.utils.RequestKey;
import com.employment.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
@Controller
@RequestMapping("/employment/user")
public class UserController extends SysBaseController{

    @Autowired
    private IUserService userService;

    /**
     * 生成验证码
     * @param model
     * @param response
     */
    @RequestMapping(value = "/login/code/query.do",method = RequestMethod.POST)
    public void createCode(Model model,HttpServletResponse response){
        try {
            VerifyCodeBean codeBean = userService.createCode();
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.SUCCESS, "操作成功！",toJson(codeBean)));
        } catch (BaseException e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }

//    @RequestMapping(value = "/login")
//    public void configCenterModel(Model model, HttpServletResponse response) {
//        try {
////            response.sendRedirect("/index.html");
//            request.getRequestDispatcher("/index.html").forward(request, response);
//        } catch (BaseException be) {
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + be.getMessage(), null));
//        } catch (Exception e) {
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
//        }
//    }

    /**
     * 登录
     * @param model
     * @param response
     */
    @RequestMapping(value = "/login/query.do",method = RequestMethod.POST)
    public void checkLogin (Model model, HttpServletResponse response) {
        try {
            UserBean userBean = getParamBean(RequestKey.query, new UserBean());
            UserBean user = userService.checkLogin(userBean);
            if(user != null){
                Cookie cookie = CookieUtils.getCookieByName(request,"user_id");
                if(cookie == null){
                    cookie = new Cookie("user_id",user.getUser_id());
                    cookie.setMaxAge(60*60*24*200);
                    response.addCookie(cookie);
                }else{
                    cookie.setValue(user.getUser_id());
                }
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.SUCCESS, "操作成功！",user.getUser_name()));
            }else{
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "登录失败！",null));
            }
        } catch (BaseException e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }

    /**
     * 注册
     */
    @RequestMapping(value = "/login/post.do",method = RequestMethod.POST)
    public void register (Model model, HttpServletResponse response) {
        try {
            UserBean user = getParamBean(RequestKey.update,UserBean.class);
            List<UserBean> list = userService.isExsit(user);
            userService.insert(user);
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.SUCCESS, "操作成功!", null));
            if(list == null && list.size()==0){
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.SUCCESS, null, null));
            }else{
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.SUCCESS, null, null));
            }
        } catch (BaseException e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "注册失败：" + e.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "注册失败：" + e.getMessage(), null));
        }
    }

    /**
     *  查询学校
     */
//    @RequestMapping(value = "/university/query.do",method = RequestMethod.POST)
//    public void qeuryCollege(Model model, HttpServletResponse response){
//        try {
//            QueryParam queryParam = getParamBean(RequestKey.query,QueryParam.class);
//            List<UniversityBean> list =userService.queryUniversities(queryParam);
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作成功！" , toJson(list)));
//        } catch (BaseException e) {
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
//        } catch (Exception e) {
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
//        }
//    }null

}
