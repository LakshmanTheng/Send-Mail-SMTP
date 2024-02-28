package com.numetry.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.numetry.mail.model.MailStructure;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailsender;
	
	@Value("$(spring.mail.username)")
	private String fromMail;
	
	public void sendmail(String mail, MailStructure mailStructure) {
		
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setFrom(fromMail);
		simpleMailMessage.setSubject(mailStructure.getSubject());
		simpleMailMessage.setText(mailStructure.getMassage());
		simpleMailMessage.setTo(mail);
		
		mailsender.send(simpleMailMessage);

	}

}
