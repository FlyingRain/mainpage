package com.wl.myweb.user.service.impl;

import com.wl.myweb.basic.utils.ModelToView;
import com.wl.myweb.basic.utils.PropertyUtil;
import com.wl.myweb.basic.utils.mail.MailContent;
import com.wl.myweb.basic.utils.mail.MailModel;
import com.wl.myweb.basic.utils.mail.MailTemplet;
import com.wl.myweb.user.model.User;
import com.wl.myweb.user.service.mapper.WebUserMapper;
import com.wl.myweb.user.service.models.UserModel;
import com.wl.myweb.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wl on 16-9-4.
 */
@Component
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    WebUserMapper webUserMapper;

    @Override
    public UserModel getUserByNamePwd(String userName, String password) {
        return webUserMapper.getUserByNamePwd(userName, password);
    }

    @Override
    public UserModel sign(User signRequest) {
        UserModel userModel = ModelToView.modelToView(signRequest, UserModel.class);
        userModel.setUserId(UUID.randomUUID().toString());
        if (webUserMapper.insertUser(userModel) == 1) {
            return userModel;
        }
        return null;
    }

    @Override
    public UserModel getUserByUserName(String userName) {
        return webUserMapper.getUserByUserName(userName);
    }

    @Override
    public String getPwdByEmail(String email) {
        logger.info("get user request : email:" + email);
        UserModel userModel = webUserMapper.getPwdByEmail(email);
        if (userModel == null) {
            return "email doesn't exist!";
        }
        boolean result = MailTemplet.sendMail(new MailContent() {
            @Override
            public MailModel getMailContent() {
                Map<String, String> recipient = new HashMap<>();
                recipient.put(userModel.getUserName(), userModel.getEmail());

                MailModel mailModel = new MailModel();
                mailModel.setSubject("密码提示");
                mailModel.setReceiverAddr(recipient);
                mailModel.setContent("");

                String mailContent = "";
                logger.info("start read file! : mailTemplate");
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                //开始使用nio读取模板文件
                try (FileChannel mailTemplateChannel = FileChannel.open(Paths.get(PropertyUtil.getProperty("user","mail.template.url")), StandardOpenOption.READ);){
                    int bytesRead = 0;
                    while ((bytesRead = mailTemplateChannel.read(buffer)) != -1) {
                        buffer.flip();
                        mailContent = mailContent + new String(buffer.array(), Charset.forName("UTF-8"));
                        buffer.clear();
                    }
                } catch (IOException e) {
                    logger.error("file error!", e);
                }
                mailModel.setContent(String.format(mailContent,userModel.getUserName(),userModel.getPassword()));
                mailModel.setSendDate(new Date());
                return mailModel;
            }
        });

        if(result){
            return "success";
        }

        return "send fail";
    }
}
