package com.employment.controller;

import com.employment.controller.common.SysBaseController;
import com.employment.service.Interface.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by apple on 2017-2-9.
 */
@Controller
@RequestMapping("/test")
public class TestController extends SysBaseController{


    @RequestMapping(value = "/configCenter")
    public void sendTo(Model model, HttpServletResponse response) {
        try {
            response.sendRedirect("/configCenter.html");
        } catch (Exception e) {

        }
    }

    @RequestMapping(value = "/index")
    public void index(Model model, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {

        }
    }

}
