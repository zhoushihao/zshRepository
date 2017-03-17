package com.employment.controller;

import com.employment.bean.StudentBean;
import com.employment.bean.StudentCatchInfoViewBean;
import com.employment.bean.common.QueryParam;
import com.employment.bean.common.ResponseResult;
import com.employment.controller.common.SysBaseController;
import com.employment.service.Interface.IStudentService;
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
@RequestMapping("/employment/student")
public class StudentController extends SysBaseController{

    @Autowired
    IStudentService studentService;

    @RequestMapping(value = "/query.do",method = RequestMethod.POST)
    public void queryStudents(Model model,HttpServletResponse response){
        try {
            QueryParam queryParam = getParamBean(RequestKey.query,QueryParam.class);
            List<StudentCatchInfoViewBean> list = studentService.queryStudents(queryParam);
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作成功！" , jsonList(list)));
        } catch (BaseException e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }

    /*
    新增，更新操作
     */
    @RequestMapping(value = "/post.do",method = RequestMethod.POST)
    public void postStudent(Model model,HttpServletResponse response){
        try {
            StudentBean bean = getParamBean(RequestKey.update,StudentBean.class);
            if(null == bean.getStudent_id()){
                studentService.insertStudent(bean);
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.SUCCESS, "学生新增成功！" , null));
            }else{
                studentService.updateStudent(bean);
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.SUCCESS, "修改成功！" , null));
            }
        } catch (BaseException e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }

    /*
    删除
     */
    @RequestMapping(value = "/delete.do",method = RequestMethod.POST)
    public void deleteWay(Model model,HttpServletResponse response){
        try {
            List<StudentBean> list = getParamBeans(RequestKey.delete,StudentBean.class);
            if(null == list){
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.SUCCESS, "没有要删除的对象!", null));
            }else{
                studentService.deleteStudent(list);
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.SUCCESS, "成功删除"+list.size()+"条记录！",null));
            }
        } catch (BaseException e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }


}
