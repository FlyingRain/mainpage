package com.wl.myweb.user.model;

import java.util.Date;

/**
 * Created by wul on 2016/12/5.
 */
public class User {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别 (1：男，2：女)
     */
    private String gender;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 电话
     */
    private String phone;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 银行卡号
     */
    private String bankAccount;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 头像
     */
    private String img;
    /**
     * 扩展字段
     */
    private String extension;
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

    public String getExtension() {
        return extension;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Date getBirthday() {
        return birthday;

    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setBirthday(Date birthday) {

        this.birthday = birthday;
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
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", email='" + email + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
