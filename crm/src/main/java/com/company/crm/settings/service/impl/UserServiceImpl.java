package com.company.crm.settings.service.impl;

import com.company.crm.settings.dao.UserDao;
import com.company.crm.utils.SqlSessionUtil;

public class UserServiceImpl {
    private UserDao userdao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
}
