package com.wl.myweb.user.service;

import com.wl.myweb.user.model.User;
import com.wl.myweb.user.service.models.UserModel;

/**
 * Created by wl on 16-9-4.
 */
public interface UserService {
    /**
     * 根据用户名密码获取用户
     * @param userName
     * @param password
     * @return
     */
    UserModel getUserByNamePwd(String userName, String password);

    /**
     * 注册用户
     * @param signRequest
     * @return
     */
    UserModel sign(User signRequest);

    /**
     * 根据userId获取用户数据
     * @param userId
     * @return
     */
    UserModel getUserByUserName(String userId);

    /**
     * 根据电子邮箱获取用户密码
     * @param email
     * @return
     */
    String getPwdByEmail(String email);
}
