package com.wl.myweb.user.service.impl;

import com.wl.myweb.basic.utils.ModelToView;
import com.wl.myweb.user.model.User;
import com.wl.myweb.user.service.mapper.WebUserMapper;
import com.wl.myweb.user.service.models.UserModel;
import com.wl.myweb.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by wl on 16-9-4.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    WebUserMapper webUserMapper;

    @Override
    public UserModel getUserByNamePwd(String userName, String password) {
        return webUserMapper.getUserByNamePwd(userName, password);
    }

    @Override
    public UserModel sign(User signRequest) {
        UserModel userModel = ModelToView.modelToView(signRequest,UserModel.class);
        userModel.setUserId(UUID.randomUUID().toString());
        if(webUserMapper.insertUser(userModel)==1){
            return userModel;
        }
        return null;
    }

    @Override
    public UserModel getUserByUserName(String userName) {
        return webUserMapper.getUserByUserName(userName);
    }

    @Override
    public String getPwdByEmail(String email) {
        return webUserMapper.getPwdByEmail(email);
    }
}
