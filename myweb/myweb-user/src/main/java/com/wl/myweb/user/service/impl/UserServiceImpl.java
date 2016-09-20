package com.wl.myweb.user.service.impl;

import com.wl.myweb.user.service.mapper.WebUserMapper;
import com.wl.myweb.user.service.models.User;
import com.wl.myweb.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wl on 16-9-4.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    WebUserMapper webUserMapper;

    @Override
    public User getUserByNamePwd(String userName, String password) {
        return webUserMapper.getUserByNamePwd(userName, password);
    }
}
