package com.employment.controller;

import com.employment.bean.ClassroomBean;
import com.employment.bean.CollegeBean;
import com.employment.bean.MajorBean;
import com.employment.bean.UniversityBean;
import com.employment.bean.common.QueryParam;
import com.employment.bean.common.ResponseResult;
import com.employment.controller.common.SysBaseController;
import com.employment.service.Interface.IConfigCenterService;
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
 * Created by apple on 2017-2-21.
 */
@Controller
@RequestMapping("/employment/configCenter")
public class ConfigController extends SysBaseController {

    @Autowired
    private IConfigCenterService configService;



    /*
    查询学校,关联的学院，专业，班级一起返回
     */
    @RequestMapping(value = "/university/query.do", method = RequestMethod.POST)
    public void queryUniversities(Model model, HttpServletResponse response) {
        try {
            QueryParam queryParam = getParamBean(RequestKey.query, QueryParam.class);
            List<UniversityBean> list = configService.queryUniversity(queryParam);
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.SUCCESS, "操作成功!", jsonList(list)));
        } catch (BaseException be) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + be.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }

    /*
    查询学院
     */
//    @RequestMapping(value = "/configCenter/college/query.do", method = RequestMethod.POST)
//    public void queryColleges(Model model, HttpServletResponse response) {
//        try {
//            CollegeBean collegeBean = getParamBean(RequestKey.queryDetail, CollegeBean.class);
//            List<CollegeBean> list = configService.queryCollege(collegeBean);
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.SUCCESS, "操作成功!", jsonList(list)));
//        } catch (BaseException be) {
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + be.getMessage(), null));
//        } catch (Exception e) {
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
//        }
//    }

    /*
    查询专业
     */
//    @RequestMapping(value = "/configCenter/major/query.do", method = RequestMethod.POST)
//    public void queryMajors(Model model, HttpServletResponse response) {
//        try {
//            MajorBean majorBean = getParamBean(RequestKey.queryDetail, MajorBean.class);
//            List<MajorBean> list = configService.queryMajor(majorBean);
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.SUCCESS, "操作成功!", jsonList(list)));
//        } catch (BaseException be) {
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + be.getMessage(), null));
//        } catch (Exception e) {
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
//        }
//    }

    /*
    查询班级
     */
//    @RequestMapping(value = "/configCenter/classroom/query.do", method = RequestMethod.POST)
//    public void queryClassrooms(Model model, HttpServletResponse response) {
//        try {
//            ClassroomBean classroomBean = getParamBean(RequestKey.queryDetail, ClassroomBean.class);
//            List<ClassroomBean> list = configService.queryClassroom(classroomBean);
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.SUCCESS, "操作成功!", jsonList(list)));
//        } catch (BaseException be) {
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + be.getMessage(), null));
//        } catch (Exception e) {
//            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
//        }
//    }

    /*
    提交，修改
     */
    @RequestMapping(value = "/university/post.do", method = RequestMethod.POST)
    public void postWay(Model model, HttpServletResponse response) {
        try {

            UniversityBean universityBean = getParamBean(RequestKey.update, UniversityBean.class);
            if (null == universityBean.getUniversity_id()){
                configService.insert(universityBean);
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.SUCCESS, "创建成功!", null));
            }else{
                configService.update(universityBean);
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.SUCCESS, "修改成功!", null));
            }
        } catch (BaseException be) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + be.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }

    /*
    删除
     */
    @RequestMapping(value = "/university/delete.do",method = RequestMethod.POST)
    public void deleteWay(Model model,HttpServletResponse response){
        try {
            List<UniversityBean> list = getParamBeans(RequestKey.delete, UniversityBean.class);
            if(null == list){
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.SUCCESS, "没有要删除的对象!", null));
            }else{
                configService.deleteUniversity(list);
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.SUCCESS, "成功删除"+list.size()+"条记录！",null));
            }
        } catch (BaseException be) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + be.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }


}


