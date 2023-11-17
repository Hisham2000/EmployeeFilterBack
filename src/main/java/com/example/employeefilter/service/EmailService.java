package com.example.employeefilter.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;

@Service
@Log
public class EmailService {
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    String fromEmail;

    @Async
    public void sendRestPasswordEmail(String email, String password, String name, String subject) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);

            message.setFrom(fromEmail, "Employee Filter Task");
            message.setTo(email);
            message.setSubject(subject);


            Context thymeleafContext = new Context();
            thymeleafContext.setVariable("toMail", email);
            thymeleafContext.setVariable("password", password);
            thymeleafContext.setVariable("userName", name);
            String htmlContent = templateEngine.process("forget-password.html", thymeleafContext);
            message.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);
            log.info("Mail Send Successfully To " + email);
        } catch (MessagingException e) {
            log.info("There is an error in mail ---->" + e.getMessage());

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
