package com.wl.myweb.user.grade.impl;

import com.wl.myweb.user.grade.UserGrade;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
public class MasterGrade extends UserGrade {

    public MasterGrade(int level,List<String> authorities) {
        this.authuorities = authorities;
        this.gradeLevel = level;
    }

    public MasterGrade(List<String> authorities) {
        //设置最高为10
        this(10,authorities);
    }

    @Override
    public List getAuthorities() {
        return null;
    }

    @Override
    public String getAward(String reason) {
        return null;
    }
}
