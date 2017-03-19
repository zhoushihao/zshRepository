package com.employment.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.kisso.web.waf.request.WafRequestWrapper;
import com.employment.bean.UserBean;
import com.employment.bean.common.BaseModel;
import com.employment.utils.CookieUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public class SysBaseController extends BaseController {

    public WafRequestWrapper getWafRequestWrapper(){
        return new WafRequestWrapper(request);
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request,response, handler);
    }

    /**
     * Controller从请求中获取指定参数获取bean对象，注意同时会向上BaseBean转型，
     * @param beanName
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> T getParamBean(String beanName,  Class<T> clazz){
        //过滤 XSS SQL 注入
        WafRequestWrapper wr = new WafRequestWrapper(request);
        String paramJson  = wr.getParameter(beanName);
        T t = JSONObject.parseObject(paramJson, clazz);
        Cookie cookie = CookieUtils.getCookieByName(request,"user_id");
        BaseModel to = (BaseModel)t;
        to.setIs_del("N");
        //TODO 给cookie设置路径
        to.setUser_id("123");
        return t;
    }

    //提供用户登录获取数据
    protected UserBean getParamBean(String beanName,  UserBean user){
        //过滤 XSS SQL 注入
        WafRequestWrapper wr = new WafRequestWrapper(request);
        String paramJson  = wr.getParameter(beanName);
        UserBean t = JSONObject.parseObject(paramJson, UserBean.class);
        t.setIs_del("N");
        return t;
    }

    /**
     * Controller从请求中获取指定参数获取所有的bean数组对象，注意同时会向上转型，
     * @param beanName
     * @param clazz
     * @param <T>
     * @return
     */
    protected <T> List<T> getParamBeans(String beanName, Class<T> clazz){
        //过滤 XSS SQL 注入
        WafRequestWrapper wr = new WafRequestWrapper(request);
        String paramJson  = wr.getParameter(beanName);
        List<T> ts = JSONObject.parseArray(paramJson, clazz);
        Cookie cookie = CookieUtils.getCookieByName(request,"user_id");
        for(T t : ts){
            BaseModel baseBean = (BaseModel) t;
            baseBean.setUser_id(cookie.getValue());;
            baseBean.setIs_del("N");
        }
        return ts;
    }

}
