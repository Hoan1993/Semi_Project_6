package sendingEmailToUs;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import model.MemberVO;
 
/**
 * A utility class that sends an e-mail message with attachments.
 * @author www.codejava.net
 *
 */
public class EmailUtility {
    public static void sendEmail(Properties smtpProperties, String toAddress,
            String subject, String message, MemberVO mVo)
            throws AddressException, MessagingException, IOException {
 
        final String userName = smtpProperties.getProperty("mail.user");
        final String password = smtpProperties.getProperty("mail.password");
         
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(smtpProperties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html; charset=UTF-8");
        
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        
        // 그냥 개행 하기 위한 용도임.
        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("", "text/html; charset=UTF-8");
        multipart.addBodyPart(messageBodyPart);
        
        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("", "text/html; charset=UTF-8");
        multipart.addBodyPart(messageBodyPart);
        
        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("", "text/html; charset=UTF-8");
        multipart.addBodyPart(messageBodyPart);
        
        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("[고객정보] 이름 : "+mVo.getName()+", 이메일 : "+mVo.getEmail()+", 주소 : "+mVo.getAddress(), 
        											"text/html; charset=UTF-8");
 
        // creates multi-part
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
/*        if (attachFiles != null && attachFiles.length > 0) {
            for (File aFile : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(aFile);
                } catch (IOException ex) {
                    throw ex;
                }
 
                multipart.addBodyPart(attachPart);
            }
        }*/
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);
 
    }
}
