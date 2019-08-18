package me.deepak.chat.utils;

import java.net.InetAddress;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author SONY
 */
public class EmailUtil {

	private static final String HOST = "smtp.gmail.com";
	private static final String PORT = "465";
	private static final String USER_ID = "deeepaksiingh100";
	private static final String PASSWORD = "deepaksingh100";
	private static final String FROM_EMAIL_ID = "deeepaksiingh100@gmail.com";

	private EmailUtil() {
	}

	public static String sendEmail(String toEmailId, String password1, String tempId) {
		try {
			Properties properties = System.getProperties();
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", HOST);
			properties.put("mail.transport.protocol", "smtps");
			properties.put("mail.smtp.port", PORT);
			properties.put("mail.smtp.user", USER_ID);
			properties.put("mail.smtp.password", PASSWORD);
			properties.put("mail.smtps.auth", "true");
			Session session = Session.getDefaultInstance(properties);
			MimeMessage message = new MimeMessage(session);
			InternetAddress fromAddress = new InternetAddress(FROM_EMAIL_ID);
			InternetAddress toAddress = new InternetAddress(toEmailId);
			message.setFrom(fromAddress);
			message.setRecipient(Message.RecipientType.TO, toAddress);
			String body = "";
			if (!toEmailId.equals("s") && !password1.equals("s")) {
				if (password1.equals("hi")) {
					message.setSubject("Signup Message");
					body = "Welcome " + toEmailId
							+ " ,<br> Thanks for Signup!!!<br>please click on the link given below to verify your emailid immediately,<br>"
							+ "otherwise you may have to delete your account and signup again,<br>if this link is expired."
							+ "<br>http://" + getIP() + ":7070/Email?tempid=" + tempId + "&email=" + toEmailId;
				} else {
					message.setSubject("Verification Code");
					body = "Welcome " + toEmailId + ",<br>Verification Code is " + tempId + "";
				}
				message.setContent(body, "text/html; charset=utf-8");
				Transport transport = session.getTransport();
				transport.connect(HOST, USER_ID, PASSWORD);
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
				return "email has sent";
			} else {
				return "enter your userid";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "try again later";

		}
	}

	public static String getIP() throws Exception {
		return InetAddress.getLocalHost().getHostAddress();
	}

}
