package contextApplication;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class MailHelper {
	private Properties props;
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	public MailHelper() {
		super();
	}
	private String host;
	private String userName;
	private String password;
	public MailHelper(String host, String username, String password) {
		super();
		this.userName = username;
		this.password = password;
		Properties propsnew = new Properties();
		propsnew.put("mail.transport.protocol", "smtp");
		propsnew.put("mail.smtp.auth", "true");
		propsnew.put("mail.smtp.host", "smtp.gmail.com");
		propsnew.put("mail.smtp.port", "465");
		propsnew.put("mail.smtp.starttls.enable", "true");
		propsnew.put("mail.smtp.ssl.enable", "true");
		this.props = propsnew;
	}
	public void sendEmail(String from,String to,String subject,String body)
	{
		//can tao ra 1 Session de nhan vao cac properties
		Session session = Session.getDefaultInstance(props, new Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication()
			{
				return new javax.mail.PasswordAuthentication(userName, password);
			}
		});
		
		//Khoi tao Message send to Email
		try 
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(body);
			
			//transport Email 
			Transport transport = session.getTransport("smtp");
			transport.connect();
			transport.send(message,message.getAllRecipients());
			transport.close();
		} 
		catch (AddressException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (MessagingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean sendEmailSend(String toEmail)
	{
		String subjectEmail = "Ban da dat hang thanh cong , Shop : Nhat Nguyen";
		String textEmail = "Chung toi se lien he ban khi da chuan bi xong hang";
		
		if(toEmail == null)
		{
			return false;
		}
		else
		{
			String host = "smtp.gmail.com";
			String username = "nhatnv7192@gmail.com";
			String password ="nhat1234";
			MailHelper mail = new MailHelper(host, username, password);
			mail.sendEmail(username, toEmail, subjectEmail, textEmail);
			
			return true;
		}
	}
}
