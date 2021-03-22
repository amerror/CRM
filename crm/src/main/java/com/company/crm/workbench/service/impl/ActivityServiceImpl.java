package com.company.crm.workbench.service.impl;

import com.company.crm.utils.SqlSessionUtil;
import com.company.crm.workbench.dao.ActivityDao;
import com.company.crm.workbench.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
}
