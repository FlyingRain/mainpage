package com.wl.myweb.user.service;

import com.wl.myweb.user.service.models.User;

/**
 * Created by wl on 16-9-4.
 */
public interface UserService {

    User getUserByNamePwd(String userName,String password);
}
