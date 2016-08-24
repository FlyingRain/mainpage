package com.wl.myweb.user.provider.impl;

import com.wl.myweb.user.grade.UserGrade;
import com.wl.myweb.user.grade.impl.MasterGrade;
import com.wl.myweb.user.provider.UserGradeProvider;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 */
@Component
public class MasterGradeProvider implements UserGradeProvider {


    private List<String> authorities;



    @Override
    public UserGrade getUserGrade() {
        authorities = getAuthorities();

        return new MasterGrade(authorities);
    }


    private List getAuthorities(){
        return null;
    }


}
