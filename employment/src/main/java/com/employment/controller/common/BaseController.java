package com.employment.controller.common;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.framework.controller.SuperController;
import com.baomidou.kisso.web.waf.request.WafRequestWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
public class BaseController extends SuperController implements HandlerInterceptor {
    public BaseController() {
    }

    public WafRequestWrapper getWafRequestWrapper() {
        return new WafRequestWrapper(this.request);
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(this.isLegalView(modelAndView)) {
            ;
        }

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    protected boolean isLegalView(ModelAndView modelAndView) {
        boolean legal = false;
        if(modelAndView != null) {
            String viewUrl = modelAndView.getViewName();
            if(viewUrl != null && viewUrl.contains("redirect:")) {
                legal = false;
            } else {
                legal = true;
            }
        }

        return legal;
    }

    protected JSONObject jsonList(List<?> list) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("list", list);
        return resultJson;
    }

    protected <T> Page<T> getPage(int size) {
        int _size = size;
        int _index = 1;
        if(this.request.getParameter("pageSize") != null) {
            _size = Integer.parseInt(this.request.getParameter("pageSize"));
        }

        if(this.request.getParameter("page") != null) {
            _index = Integer.parseInt(this.request.getParameter("page"));
        }

        return new Page(_index, _size);
    }

    protected String booleanToString(boolean rlt) {
        return rlt?"true":"false";
    }
}
