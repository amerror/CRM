package com.company.crm.workbench.service.impl;

import com.company.crm.utils.SqlSessionUtil;
import com.company.crm.workbench.dao.ActivityDao;
import com.company.crm.workbench.domain.Activity;
import com.company.crm.workbench.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);

    @Override
    public boolean save(Activity a) {
        boolean flag = true;

        int count = activityDao.save(a);

        if(count != 1){
            flag = false;
        }

        return flag;
    }
}
