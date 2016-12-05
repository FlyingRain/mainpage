package com.wl.myweb.user.service.impl;

import com.wl.myweb.user.model.SignRequest;
import com.wl.myweb.user.service.mapper.WebUserMapper;
import com.wl.myweb.user.service.models.UserModel;
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
    public UserModel getUserByNamePwd(String userName, String password) {
        return webUserMapper.getUserByNamePwd(userName, password);
    }

    @Override
    public UserModel sign(SignRequest signRequest) {
        UserModel userModel = new UserModel();
        userModel.setBirthday(userModel.getBirthday());
        userModel.setEmail(signRequest.getEmail());
        userModel.setUserName(signRequest.getUserName());
        userModel.setPassword(signRequest.getPassword());
        if(webUserMapper.insertUser(userModel)==1){
            return userModel;
        }
        return null;
    }
}
