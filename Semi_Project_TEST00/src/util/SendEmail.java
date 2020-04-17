package util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	public SendEmail() {

	}

	public void sendEmail(String name, String email, String pwd) {
		String host = "smtp.naver.com";
		final String user = "";
		final String password = "";
		
		String to = email;

		// Get the session object
		/*
		 * defaultProps.setProperty("mail.smtp.host", "smtp.naver.com");
		 * defaultProps.setProperty("mail.smtp.port", "587");
		 * defaultProps.setProperty("mail.user", "sist2020");
		 * defaultProps.setProperty("mail.password", "Sist2020!");
		 * defaultProps.setProperty("mail.smtp.starttls.enable", "true");
		 * defaultProps.setProperty("mail.smtp.auth", "true");
		 */

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587"); //587
		props.put("mail.enable.ssl", "true");
		props.put("mail.user", user);
		props.put("mail.password", password);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.trust", "smtp.naver.com");

		/*
		 * props.put("mail.smtp.socketFactory.port", "587");
		 * props.setProperty("mail.smtp.socketFactory.class",
		 * "javax.net.ssl.SSLSocketFactory");
		 * props.put("mail.smtp.socketFactory.fallback", "false");
		 * props.put("mail.smtp.port", "587");
		 */

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Subject
			message.setSubject("[TET] 임시 비밀번호를 발송해 드립니다.");

			// Text
			message.setText(name+"님의 임시 비빌번호는   [" +pwd+"]   입니다.");

			// send the message
			Transport.send(message);
			System.out.println("message sent successfully...");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
