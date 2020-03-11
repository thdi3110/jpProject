package MEMBER.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	private String email;
	private int code;
	
	public SendMail() {
	}	
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public void sendmail(String email, int code) {		
		
		  String server = "smtp.gmail.com";
		  String sendID = "jpsystem2020@gmail.com";
		  String sendPW = "jpproject";
		  String sendMailAddr = "jpsystem2020@gmail.com";
		  int smtpPort=465;
		  
		  String recEmailAddr= email;
		  String sub = "Safety Pet 회원가입 인증메일입니다.";
		  String cont = code+"를 입력해주세요";
		  
		  Properties props = System.getProperties();
		  
		  props.put("mail.smtp.host", server);
		  props.put("mail.smtp.port", smtpPort);
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.ssl.enable", "true");
		  props.put("mail.smtp.ssl.trust", server);
		  
		  Session session = Session.getDefaultInstance(props, new Authenticator(){
		   protected PasswordAuthentication getPasswordAuthentication(){
		    return new PasswordAuthentication(sendID, sendPW);
		   }
		  });
		  
		  session.setDebug(true);
		  
		  Message mimeMessage = new MimeMessage(session);
		  try {
		   mimeMessage.setFrom(new InternetAddress( sendMailAddr ));
		   mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recEmailAddr));
		   mimeMessage.setSubject(sub);
		   mimeMessage.setText(cont);
		   Transport.send(mimeMessage);
		  } catch (AddressException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (MessagingException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  
		 }
}
