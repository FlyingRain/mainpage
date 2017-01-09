package model;

import java.util.Date;

/**
 * Created by wulei on 1/9/17.
 */
public class Comments {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 评论时间
     */
    private Date time;
    /**
     * 内容
     */
    private String content;
    /**
     * 用户Ｉｄ
     */
    private String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "userName='" + userName + '\'' +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
