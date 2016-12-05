package com.wl.myweb.user.model;

import java.util.Date;

/**
 * Created by wul on 2016/12/5.
 */
public class SignRequest {

    private String userName;

    private String password;

    private Date birthdat;

    private String phone;

    private String email;

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdat() {
        return birthdat;
    }

    public void setBirthdat(Date birthdat) {
        this.birthdat = birthdat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SignRequest{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", birthdat=" + birthdat +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
