package com.wl.myweb.user.service.mapper;

import com.wl.myweb.user.service.models.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wl on 16-9-4.
 */
public interface WebUserMapper {

    @Select("select user_id as userId,user_name as userName,birthday,gender,email,phone,address,director,extension from webuser where user_name=#{userName} and password=#{password}")
    UserModel getUserByNamePwd(@Param("userName") String userName, @Param("password") String password);

    @Insert("insert into webuser(user_name,birthday,gender.email,phone,address,director,extension) values " +
            "(#{userModel.userName},#{userModel.birthday},#{userModel.gender},#{userModel.email},#{userModel.phone},#{userModel.address},#{userModel.director},#{userModel.extension})")
    int insertUser(@Param("userModel") UserModel userModel);

}
