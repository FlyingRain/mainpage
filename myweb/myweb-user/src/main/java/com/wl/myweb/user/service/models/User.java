package com.wl.myweb.user.service.models;

import com.wl.myweb.user.grade.context.GradeContext;

/**
 * Created by wul on 2016/8/18.
 */
public class User {
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
    /**
     * 年龄
     */
    private String age;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 电话
     */
    private String phone;

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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
}
