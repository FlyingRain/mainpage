package com.wl.myweb.user.service.mapper;

import com.wl.myweb.user.service.models.UserModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by wl on 16-9-4.
 */
public interface WebUserMapper {

    @Select("select userId as userId,userName as userName,birthday,gender,email,phone,extension from webuser where userName=#{userName} and password=#{password}")
    UserModel getUserByNamePwd(@Param("userName") String userName, @Param("password") String password);

    @Insert("insert into webuser(userId,userName,birthday,gender,email,phone,idCard,bankAccount,img,password,extension) values " +
            "(#{userModel.userId},#{userModel.userName},#{userModel.birthday},#{userModel.gender},#{userModel.email},#{userModel.phone},#{userModel.idCard},#{userModel.bankAccount},#{userModel.img},#{userModel.password},#{userModel.extension})")
    int insertUser(@Param("userModel") UserModel userModel);

    @Select("select userId as userId,userName as userName,birthday,gender,email,phone,password,extension from webuser where userName=#{userName}")
    UserModel getUserByUserName(@Param("userName") String userId);
    @Select("select password from webuser where email=#{email}")
    String getPwdByEmail(String email);
}
