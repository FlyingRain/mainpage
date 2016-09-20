package com.wl.myweb.user.service.mapper;

import com.wl.myweb.user.service.models.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wl on 16-9-4.
 */
public interface WebUserMapper {

    @Select("select user_id as userId,user_name as userName,age,gender,email,phone,address,director,extension from webuser where user_name=#{userName} and password=#{password}")
    User getUserByNamePwd(@Param("userName") String userName, @Param("password") String password);
}
