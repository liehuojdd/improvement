package com.util;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Email {

    String HOST = ""; // smtp server
    String FROM = ""; 
    String TO = ""; 
    String AFFIX = ""; // Attachement
    String USER = ""; 
    String PWD = ""; 
    String SUBJECT = "";
    String[] TOS = null;
    String Port="";
    
    /**
     * Test with 163 and QQ email.
     * Error: java.lang.ClassNotFoundException: com.sun.mail.smtp.SMTPTransport
     * <dependency>
	 * <groupId>javax.mail</groupId>
	 * <artifactId>mailapi</artifactId>
	 * Resolved:becasue it's not mailapi in dependency, it should be mail.
     */
    /**
     * @param to: If has email list. split with ','
     * @param filePath: Attachment path
     */
    public Email(String to,String filePath) {
    	this.TO=to;
        TOS=TO.split(",");
        AFFIX=filePath;
//        FROM="456@163.com";
//        HOST="smtp.163.com";
//        USER="zwm_8086";//It's no @something
//        PWD="456";
//        Port="25";
        FROM="456@qq.com";
        HOST="smtp.qq.com";
        USER="456@qq.com";
        PWD="123";
        Port="465";
    }

    /**
     * Send email
     */
    public void send(String subject,String context) {
    	this.SUBJECT=subject;
        Properties props = new Properties();
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", Port);
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.ssl.enable", "true");//163 email can remove this line, it's false
        //props.put("mail.debug", "true");//Not useful.

        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(FROM));// Add from address
            InternetAddress[] sendTo = new InternetAddress[TOS.length]; // Add to address
            for (int i = 0; i < TOS.length; i++) {  
                sendTo[i] = new InternetAddress(TOS[i]);  
            }
            message.addRecipients(Message.RecipientType.TO,sendTo);
            //message.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(FROM));//Add cc to myself
            message.setSubject(SUBJECT);
            Multipart multipart = new MimeMultipart();
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText(context);
            multipart.addBodyPart(contentPart);
            if(!AFFIX.isEmpty()){//Attachment
                 BodyPart messageBodyPart = new MimeBodyPart();
                 DataSource source = new FileDataSource(AFFIX);
                 messageBodyPart.setDataHandler(new DataHandler(source));//Attachment content
                 sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();//Attachment title
                 messageBodyPart.setFileName("=?GBK?B?"+ enc.encode(AFFIX.getBytes()) + "?=");
                 multipart.addBodyPart(messageBodyPart);
            }
            message.setContent(multipart);
            message.saveChanges();
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, USER, PWD);//Connect to the server
            transport.sendMessage(message, message.getAllRecipients());//Send email
            transport.close();//Close connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    
}

