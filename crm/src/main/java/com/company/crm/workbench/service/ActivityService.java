package com.company.crm.workbench.service;

import com.company.crm.vo.PagInationVo;
import com.company.crm.workbench.domain.Activity;

import java.util.Map;

public interface ActivityService {
    boolean save(Activity a);

    PagInationVo<Activity> pageList(Map<String, Object> map);
}
