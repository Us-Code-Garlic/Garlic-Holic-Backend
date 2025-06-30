package com.garlicholic.backend.domain.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.UnsupportedEncodingException;

@Service
@RequiredArgsConstructor
public class MailCoreService {

    @Value("${spring.mail.username}")
    private String SENDER_EMAIL;

    private final JavaMailSender mailSender;

    public void sendMail(String toEmail, ReportMailData reportMailData) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom(new InternetAddress(SENDER_EMAIL, "나마늘기억해", "UTF-8"));
        helper.setTo(toEmail);
        helper.setSubject("[나마늘기억해] 🧄 주간 건강 리포트를 보내드려요 !");

        String mailContent = ReportTemplateGenerator.generate(reportMailData);
        helper.setText(mailContent, true);

        ClassPathResource banner = new ClassPathResource("static/banner.png");
        helper.addInline("banner", banner);

        mailSender.send(message);
    }

}
