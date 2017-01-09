package com.wl.myweb.user.service;

import com.wl.myweb.user.model.SignRequest;
import com.wl.myweb.user.service.models.UserModel;

/**
 * Created by wl on 16-9-4.
 */
public interface UserService {

    UserModel getUserByNamePwd(String userName, String password);

    UserModel sign(SignRequest signRequest);
}
