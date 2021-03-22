package com.company.crm.settings.service;

import com.company.crm.exception.LoginException;
import com.company.crm.settings.domain.User;

import java.util.List;

public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
