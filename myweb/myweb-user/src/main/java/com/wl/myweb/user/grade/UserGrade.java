package com.wl.myweb.user.grade;

import java.util.List;

/**
 * Created by wul on 2016/8/18.
 */
public abstract class UserGrade {
    /**
     * 等级（和签到以及后续获得奖励有关）
     */
    protected int gradeLevel;
    /**
     * 权利
     */
    protected List<String> authuorities;

     public abstract List getAuthorities();

    public abstract String getAward(String reason);

    public void setAuthorities(List<String> authorities){
        this.authuorities = authorities;
    }

    public void addAuthorities(String authority){
        this.authuorities.add(authority);
    }
}
