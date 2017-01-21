package com.wl.myweb.basic.utils.mail;

import com.wl.myweb.basic.utils.PropertyUtil;
import com.wl.myweb.basic.utils.mail.MailContent;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by wul on 1/19/17.
 */
public class MailTemplet {

    private static String sender ;

    @PostConstruct
    public void init(){
        sender = PropertyUtil.getProperty("user","mail.sender");
        if(sender==null){
            throw new RuntimeException("sender is null!");
        }
    }
    /**
     * 发送邮件模板方法
     * @param content
     * @return
     */
    public static boolean sendMail(MailContent content){
        //1.准备发送邮件前的配置
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", PropertyUtil.getProperty("user","mail.transport.protocol"));
        properties.setProperty("mail.host",PropertyUtil.getProperty("user","mail.host"));
        properties.setProperty("mail.smtp.auth",PropertyUtil.getProperty("user","mail.smtp.auth"));
        //2.创建会话
        Session session = Session.getDefaultInstance(properties);
        //开启debug模式可以查看发送log
        session.setDebug(true);

        MimeMessage mimeMessage =


        return true;
    }

    /**
     * 设置要发送的邮件
     * @param session
     * @param mailModel
     * @return
     */
    private MimeMessage createMail(Session session,MailModel mailModel){
        MimeMessage mimeMessage = new MimeMessage(session);

        try {
            mimeMessage.setFrom(new InternetAddress(sender));
            //设置收件人
            Map<String,String> recevers = mailModel.getReceiverAddr();
            if(recevers.isEmpty()){
                return null;
            }
            InternetAddress[] addresses  = new InternetAddress[recevers.size()];
            Iterator<String> iterator = recevers.keySet().iterator();
            int i= 0;
            while (iterator.hasNext()){
                String name = iterator.next();
                addresses[i++] = new InternetAddress(recevers.get(name),name,"UTF-8");
            }
            mimeMessage.setRecipients(MimeMessage.RecipientType.TO,addresses);

            //设置抄送人
            Map<String,String> ccAddr  = mailModel.getCcAddr();
            if (!ccAddr.isEmpty()){
                InternetAddress[] ccAddresses = new InternetAddress[ccAddr.size()];
                Iterator<String> iterator1 = ccAddr.keySet().iterator();
                int n= 0;
                while (iterator1.hasNext()){
                    String name = iterator1.next();
                    addresses[n++] = new InternetAddress(ccAddr.get(name),name,"UTF-8");
                }
                mimeMessage.setRecipients(MimeMessage.RecipientType.CC,addresses);

            }

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
