package com.company.crm.settings.web.controller;

import com.company.crm.settings.domain.User;
import com.company.crm.settings.service.UserService;
import com.company.crm.settings.service.impl.UserServiceImpl;
import com.company.crm.utils.MD5Util;
import com.company.crm.utils.PrintJson;
import com.company.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到用户控制器");
        System.out.println("ContextPath:"+request.getContextPath());
        String path = request.getServletPath();
        if("/settings/user/login.do".equals(path)){
            login(request,response);
        }else if("/settings/user/xxx.do".equals(path)){

        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("进入验证登录操作");
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");

        loginPwd = MD5Util.getMD5(loginPwd);
        String ip = request.getRemoteAddr();
        System.out.println("ip地址："+ip);
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());

        try{
//            User user = us.login(loginAct,loginPwd,ip);
//            request.getSession().setAttribute("user",user);
//            PrintJson.printJsonFlag(response,true);

        }catch(Exception e){
            e.printStackTrace();
            String msg = e.getMessage();
            //P63 17分钟

        }
    }
}
