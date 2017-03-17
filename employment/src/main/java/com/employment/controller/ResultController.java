package com.employment.controller;

import com.employment.bean.ResultBean;
import com.employment.bean.UniversityBean;
import com.employment.bean.common.QueryParam;
import com.employment.bean.common.ResponseResult;
import com.employment.controller.common.SysBaseController;
import com.employment.service.Interface.IResultService;
import com.employment.utils.BaseException;
import com.employment.utils.RequestKey;
import com.employment.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by apple on 2017-2-9.
 */
@Controller
@RequestMapping("/employment/result")
public class ResultController extends SysBaseController{

    @Autowired
    IResultService resultService;

    /*
    对学校的统计
     */
    @RequestMapping(value = "/university/query.do",method = RequestMethod.POST)
    public void universityResult(Model model,HttpServletResponse response){
        try {
            QueryParam queryParam = getParamBean(RequestKey.query,QueryParam.class);
            List<ResultBean> list = resultService.countUniversity(queryParam);
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作成功！" , jsonList(list)));
        } catch (BaseException e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }

    /*
    对学院的统计
     */
    @RequestMapping(value = "/college/query.do",method = RequestMethod.POST)
    public void collegeResult(Model model,HttpServletResponse response){
        try {
            QueryParam queryParam = getParamBean(RequestKey.query,QueryParam.class);
            List<ResultBean> list = resultService.countCollege(queryParam);
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作成功！" , jsonList(list)));
        } catch (BaseException e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }

    /*
    对专业的统计
     */
    @RequestMapping(value = "/major/query.do",method = RequestMethod.POST)
    public void majorResult(Model model,HttpServletResponse response){
        try {
            QueryParam queryParam = getParamBean(RequestKey.query,QueryParam.class);
            List<ResultBean> list = resultService.countMajor(queryParam);
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作成功！" , jsonList(list)));
        } catch (BaseException e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }

    /*
    对班级的统计
     */
    @RequestMapping(value = "/classroom/query.do",method = RequestMethod.POST)
    public void classroomResult(Model model,HttpServletResponse response){
        try {
            QueryParam queryParam = getParamBean(RequestKey.query,QueryParam.class);
            List<ResultBean> list = resultService.countClassroom(queryParam);
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作成功！" , jsonList(list)));
        } catch (BaseException e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }


}
