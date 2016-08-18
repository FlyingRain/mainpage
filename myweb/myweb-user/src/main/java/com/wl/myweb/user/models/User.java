package com.wl.myweb.user.models;

import java.util.List;

/**
 * Created by wul on 2016/8/18.
 */
public interface User {
    //登录
    User login();
    //登出
    void logOut();
    //获取权限
    List getAuthorities();
    //根据权利做一些事情
    void doSomething();
}
