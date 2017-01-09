package model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wulei on 1/9/17.
 */
public class ArticleModel {
    /**
     * 文章编号
     */
    private String articleId;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String userName;
    /**
     * 点赞数
     */
    private int upNumber;
    /**
     * 图片
     */
    private byte[] img;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 用户Ｉｄ
     */
    private String userId;
    /**
     * 文章评论
     */
    private List<Comments> comments;

    public String getArticleId() {

        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUpNumber() {
        return upNumber;
    }

    public void setUpNumber(int upNumber) {
        this.upNumber = upNumber;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
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

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ArticleModel{" +
                "articleId='" + articleId + '\'' +
                ", title='" + title + '\'' +
                ", userName='" + userName + '\'' +
                ", upNumber=" + upNumber +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                ", comments=" + comments +
                '}';
    }
}

