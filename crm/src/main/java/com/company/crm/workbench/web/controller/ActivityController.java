package com.company.crm.workbench.web.controller;

import com.company.crm.settings.domain.User;
import com.company.crm.settings.service.UserService;
import com.company.crm.settings.service.impl.UserServiceImpl;
import com.company.crm.utils.*;
import com.company.crm.vo.PagInationVo;
import com.company.crm.workbench.domain.Activity;
import com.company.crm.workbench.service.ActivityService;
import com.company.crm.workbench.service.impl.ActivityServiceImpl;
import javafx.concurrent.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ActivityController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到市场活动控制器");
        System.out.println("ContextPath:"+request.getContextPath());
        String path = request.getServletPath();
        System.out.println(path);
        if("/workbench/Activity/getUserList.do".equals(path)){
            getUserList(request,response);
        }else if("/workbench/Activity/save.do".equals(path)){
            save(request,response);
        }else if("/workbench/Activity/pageList.do".equals(path)){
            pageList(request, response);
        }

    }

    private void pageList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进行分页查询");
        String name = request.getParameter("name");
        String owner = request.getParameter("owner");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String pageNoStr = request.getParameter("pageNo");
        String pageSizeStr = request.getParameter("pageSize");
        int pageNo = Integer.valueOf(pageNoStr);
        int pageSize = Integer.valueOf(pageSizeStr);
        int skipCount = (pageNo-1)*pageSize;
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("owner", owner);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("pageSize", pageSize);
        map.put("skipCount", skipCount);
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        PagInationVo<Activity> vo = as.pageList(map);
        PrintJson.printJsonObj(response, vo);

    }

    private void save(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行市场活动添加操作");
        String id = UUIDUtil.getUUID();
        String owner = request.getParameter("owner");
        String name = request.getParameter("name");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String cost = request.getParameter("cost");
        String description = request.getParameter("description");
        String createTime = DateTimeUtil.getSysTime();
        String createBy = ((User)request.getSession().getAttribute("user")).getName();

        Activity a = new Activity();
        a.setId(id);
        a.setOwner(owner);
        a.setName(name);
        a.setStartDate(startDate);
        a.setEndDate(endDate);
        a.setCost(cost);
        a.setDescription(description);
        a.setCreateTime(createTime);
        a.setCreateBy(createBy);

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        boolean flag = as.save(a);
        PrintJson.printJsonFlag(response, flag);

    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("取得用户信息列表");
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> userList =  us.getUserList();
        PrintJson.printJsonObj(response, userList);
    }


}
