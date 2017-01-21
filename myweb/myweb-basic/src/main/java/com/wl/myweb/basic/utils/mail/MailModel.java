package com.wl.myweb.basic.utils.mail;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wul on 1/22/17.
 */
public class MailModel {
    /**
     * 收件人地址
     */
    private Map<String,String> receiverAddr;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 抄送人地址列表
     */
    private Map<String,String> ccAddr;
    /**
     * 密送地址列表
     */
    private Map<String,String> bccAddr;
    /**
     * 邮件内容
     */
    private String content;
    /**
     * 邮件发送时间
     */
    private Date sendDate;



    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Map<String, String> getReceiverAddr() {
        return receiverAddr;
    }

    public void setReceiverAddr(Map<String, String> receiverAddr) {
        this.receiverAddr = receiverAddr;
    }

    public Map<String, String> getCcAddr() {
        return ccAddr;
    }

    public void setCcAddr(Map<String, String> ccAddr) {
        this.ccAddr = ccAddr;
    }

    public Map<String, String> getBccAddr() {
        return bccAddr;
    }

    public void setBccAddr(Map<String, String> bccAddr) {
        this.bccAddr = bccAddr;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return "MailModel{" +
                ", receiverAddr='" + receiverAddr + '\'' +
                ", subject='" + subject + '\'' +
                ", ccAddr=" + ccAddr +
                ", sendDate=" + sendDate +
                '}';
    }
}
