package com.company.crm.workbench.web.controller;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到市场活动控制器");
        System.out.println("ContextPath:"+request.getContextPath());
        String path = request.getServletPath();
        if("/workbench/Activity/getUserList.do".equals(path)){
            getUserList(request,response);
        }else if("/settings/user/xxx.do".equals(path)){
            //xxx(request,response)
        }

    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("取得用户信息列表");
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> userList =  us.getUserList();
        PrintJson.printJsonObj(response, userList);
    }


}
