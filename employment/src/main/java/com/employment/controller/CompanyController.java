package com.employment.controller;

import com.employment.bean.CompanyBean;
import com.employment.bean.StudentCatchInfoViewBean;
import com.employment.bean.common.QueryParam;
import com.employment.bean.common.ResponseResult;
import com.employment.controller.common.SysBaseController;
import com.employment.service.Interface.ICompanyService;
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
@RequestMapping("/employment/company")
public class CompanyController extends SysBaseController{

    @Autowired
    ICompanyService companyService;

    /*
    模糊查询
     */
    @RequestMapping(value = "/query.do",method = RequestMethod.POST)
    public void queryStudents(Model model,HttpServletResponse response){
        try {
            QueryParam queryParam = getParamBean(RequestKey.query,QueryParam.class);
            List<CompanyBean> list = companyService.selectCompanies(queryParam);
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
    public void postCompany(Model model,HttpServletResponse response){
        try {
            CompanyBean bean = getParamBean(RequestKey.update,CompanyBean.class);
            if(null == bean.getCompany_id()){
                companyService.insertCompany(bean);
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.SUCCESS, "学生新增成功！" , null));
            }else{
                companyService.updateCompany(bean);
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
            List<CompanyBean> list = getParamBeans(RequestKey.delete,CompanyBean.class);
            if(null == list){
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.SUCCESS, "没有要删除的对象!", null));
            }else{
                companyService.deleteCompanies(list);
                ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.QUERYTYPE, ResponseResult.SUCCESS, "成功删除"+list.size()+"条记录！",null));
            }
        } catch (BaseException e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        } catch (Exception e) {
            ResponseUtils.renderJson(response, new ResponseResult(ResponseResult.POSTTYPE, ResponseResult.ERROR, "操作失败：" + e.getMessage(), null));
        }
    }

}
