package com.wl.myweb.user.models;

import java.util.List;

/**
 * Created by wul on 2016/8/18.
 */
public interface User {
    //��¼
    User login();
    //�ǳ�
    void logOut();
    //��ȡȨ��
    List getAuthorities();
    //����Ȩ����һЩ����
    void doSomething();
}
