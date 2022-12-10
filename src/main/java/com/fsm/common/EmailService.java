package com.fsm.common;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
	
	private static final Logger LOGGER = LogManager.getLogger(EmailService.class);
	
	private static final String VELOCITY_TEMPLATE_PREFIX = "velocity/";
	
	private static final String ENCODING = "utf-8";
	
//	@Autowired
//	private VelocityEngine velocityEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
//	@Async
//	public void sendEmail(String toAddress, String subject, String velocityTemplate,
//			Map<String, Object> velocityTemplateProperties) throws MessagingException, IOException {
//		String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, VELOCITY_TEMPLATE_PREFIX + velocityTemplate, "UTF-8",
//				velocityTemplateProperties);
//		sendEmail(toAddress, subject, body);
//	}	

	@Async
	public void sendEmail(String toAddress, String subject, String body) throws MessagingException, IOException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, ENCODING);
		helper.setText(body, true);
		helper.setTo(toAddress);
		helper.setSubject(subject);		
		javaMailSender.send(mimeMessage);
		LOGGER.info("Sent email: {}", mimeMessage.getContent());
	}
}
