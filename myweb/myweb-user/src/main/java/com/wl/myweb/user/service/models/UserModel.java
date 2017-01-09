package com.wl.myweb.user.service.models;

import com.wl.myweb.user.grade.context.GradeContext;

import java.util.Date;

/**
 * Created by wul on 2016/8/18.
 */
public class UserModel {
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 性别
     */
    private String gender;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 生日
     */
    private Date birthday;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String phone;

    private String password;
    /**
     * 所属列别
     */
    private GradeContext gradeContext;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserId() {

        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public GradeContext getGradeContext() {
        return gradeContext;
    }

    public void setGradeContext(GradeContext gradeContext) {
        this.gradeContext = gradeContext;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gradeContext=" + gradeContext +
                '}';
    }
}
