package com.company.crm.workbench.service.impl;

import com.company.crm.utils.SqlSessionUtil;
import com.company.crm.vo.PagInationVo;
import com.company.crm.workbench.dao.ActivityDao;
import com.company.crm.workbench.domain.Activity;
import com.company.crm.workbench.service.ActivityService;

import java.util.List;
import java.util.Map;

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

    @Override
    public PagInationVo<Activity> pageList(Map<String, Object> map) {
        int total = activityDao.getTotalByCondition(map);
        List<Activity> dataList = activityDao.getActivityListByCondition(map);
        PagInationVo<Activity> vo = new PagInationVo<>();
        vo.setTotal(total);
        vo.setDataList(dataList);
        return vo;
    }
}
