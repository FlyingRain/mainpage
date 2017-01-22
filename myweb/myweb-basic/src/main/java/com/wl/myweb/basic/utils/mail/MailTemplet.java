package com.wl.myweb.basic.utils.mail;

import com.wl.myweb.basic.utils.PropertyUtil;
import com.wl.myweb.basic.utils.mail.MailContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
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

    private static Logger logger = LoggerFactory.getLogger(MailTemplet.class);

    private static String sender;

    static {
        sender = PropertyUtil.getProperty("user", "mail.sender");
        if (sender == null) {
            throw new RuntimeException("sender is null!");
        }
    }

    /**
     * 发送邮件模板方法
     *
     * @param content
     * @return
     */
    public static boolean sendMail(MailContent content) {
        //1.准备发送邮件前的配置
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", PropertyUtil.getProperty("user", "mail.transport.protocol"));
        properties.setProperty("mail.host", PropertyUtil.getProperty("user", "mail.host"));
        properties.setProperty("mail.smtp.auth", PropertyUtil.getProperty("user", "mail.smtp.auth"));
        //2.创建会话
        Session session = Session.getDefaultInstance(properties);
        //开启debug模式可以查看发送log
        session.setDebug(true);

        //3.创建一封邮件
        MimeMessage mimeMessage = createMail(session, content.getMailContent());
        if (mimeMessage == null) {
            logger.error("create mail failed! mail is null!");
            return false;
        }

        Transport transport = null;
        //4.根据session获取传输对象
        try {
            transport = session.getTransport();

            //5.使用邮箱帐号密码连接服务器
            transport.connect(PropertyUtil.getProperty("user", "mail.sender"), PropertyUtil.getProperty("user", "mail.sender.password"));

            //6.发送所有邮件
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());

            //transport.sendMessage(mimeMessage,new InternetAddress[]{new InternetAddress("15852802019@163.com")});
        } catch (NoSuchProviderException e) {
            logger.error("create connection failed!", e);
            return false;
        } catch (MessagingException e) {
            logger.error("send mail failed!", e);
            return false;
        } finally {
            try {
                transport.close();
            } catch (MessagingException e) {
                logger.error("close transport failed!", e);
            }
        }
        return true;
    }

    /**
     * 设置要发送的邮件
     *
     * @param session
     * @param mailModel
     * @return
     */
    private static MimeMessage createMail(Session session, MailModel mailModel) {
        MimeMessage mimeMessage = new MimeMessage(session);

        try {
            mimeMessage.setFrom(new InternetAddress(sender));
            //设置收件人
            Map<String, String> recevers = mailModel.getReceiverAddr();
            if (recevers == null || recevers.isEmpty()) {
                return null;
            }
            InternetAddress[] addresses = new InternetAddress[recevers.size()];
            Iterator<String> iterator = recevers.keySet().iterator();
            int i = 0;
            while (iterator.hasNext()) {
                String name = iterator.next();
                addresses[i++] = new InternetAddress(recevers.get(name));
            }
            mimeMessage.setRecipients(MimeMessage.RecipientType.TO, addresses);

            //设置抄送人
            Map<String, String> ccAddr = mailModel.getCcAddr();
            if (ccAddr != null && !ccAddr.isEmpty()) {
                InternetAddress[] ccAddresses = new InternetAddress[ccAddr.size()];
                Iterator<String> iterator1 = ccAddr.keySet().iterator();
                int n = 0;
                while (iterator1.hasNext()) {
                    String name = iterator1.next();
                    ccAddresses[n++] = new InternetAddress(ccAddr.get(name));
                }
                mimeMessage.setRecipients(MimeMessage.RecipientType.CC, ccAddresses);

            }

            //设置秘密抄送人
            Map<String, String> bccAddr = mailModel.getBccAddr();
            if (bccAddr != null && !bccAddr.isEmpty()) {
                InternetAddress[] bccAddresses = new InternetAddress[bccAddr.size()];
                Iterator<String> iterator1 = bccAddr.keySet().iterator();
                int j = 0;
                while (iterator1.hasNext()) {
                    String name = iterator1.next();
                    bccAddresses[j++] = new InternetAddress(bccAddr.get(name));
                }
                mimeMessage.setRecipients(MimeMessage.RecipientType.BCC, bccAddresses);
            }
            //设置主题
            mimeMessage.setSubject(mailModel.getSubject());
            //设置正文
            mimeMessage.setContent(mailModel.getContent(), "text/html;charset=UTF-8");
            //设置发送时间
            mimeMessage.setSentDate(mailModel.getSendDate());
            //保存设置
            mimeMessage.saveChanges();
            return mimeMessage;

        } catch (MessagingException e) {

            logger.error("create mail failed!", e);
        }
        return null;
    }

}
