package com.wl.myweb.user.service.mapper;

import com.wl.myweb.user.service.models.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wl on 16-9-4.
 */
public interface WebUserMapper {

    @Select("select userId,userName,age,gender,email,phone,address,director,extension form webuser where username=#{username} and password=#{password}")
    User getUserByNamePwd(@Param("userName") String userName, @Param("password") String password);
}
