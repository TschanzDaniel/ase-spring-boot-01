package org.baeldung.test;

import java.util.Locale;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.baeldung.Application;
import org.baeldung.persistence.dao.UserRepository;
import org.baeldung.persistence.model.User;
import org.baeldung.service.IUserService;
import org.baeldung.spring.TestDbConfig;
import org.baeldung.spring.TestIntegrationConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class, TestDbConfig.class, TestIntegrationConfig.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class MailTest {
	
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private MessageSource messages;
    
    @Autowired
    private Environment env;
    
    @Autowired
    private IUserService service;
    
    @Autowired
    private JavaMailSender mailSender;
    
    private User user; 
    
    
    @Before
    public void init() {
       user = userRepository.findByEmail("M.Bachmann@united-portal.com");
        if (user == null) {
            user = new User();
            user.setFirstName("Matthias");
            user.setLastName("Bachmann");
            user.setPassword(passwordEncoder.encode("test"));
            user.setEmail("M.Bachmann@united-portal.com");
            user.setEnabled(true);
            userRepository.save(user);
        } else {
            user.setPassword(passwordEncoder.encode("test"));
            userRepository.save(user);
        }
    }

    @Test
    public void mailTest () throws MessagingException {
    	
        final String token = UUID.randomUUID().toString();
        service.createVerificationTokenForUser(user, token);

       	//SimpleMailMessage email = constructEmailMessage (user, token);
        MimeMessage email = mailSender.createMimeMessage();
        constructMimeEmailMessage(email, user, token);
        mailSender.send(email);
     	
    	
    }
    
    @SuppressWarnings("unused")
	private final SimpleMailMessage constructEmailMessage(final User user, final String token) {
        final String recipientAddress = user.getEmail();
        final String subject = "Registration Confirmation";
        final String serverPort = env.getProperty("server.port");
        final String confirmationUrl = "http:localhost:" + serverPort + "/registrationConfirm.html?token=" + token;
        final String message = messages.getMessage("message.regSucc", null, new Locale("de_CH"));
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + " \r\n" + "<a href=\"" + confirmationUrl +"\">" + confirmationUrl + "</a>" );
        email.setFrom(env.getProperty("support.email"));
        return email;
    }
    
    private void constructMimeEmailMessage(MimeMessage email, final User user, final String token) throws MessagingException {
        final String recipientAddress = user.getEmail();
        final String subject = "Registration Confirmation";
        final String serverPort = env.getProperty("server.port");
        final String confirmationUrl = "http:localhost:" + serverPort + "/registrationConfirm.html?token=" + token;
        final String message = messages.getMessage("message.regSucc", null, new Locale("de_CH"));
        final MimeMessageHelper helper = new MimeMessageHelper(email);
        helper.setTo(recipientAddress);
        helper.setSubject(subject);
        helper.setText(message + " \r\n" + "<a href=\"" + confirmationUrl +"\">" + confirmationUrl + "</a>",true );
        helper.setFrom(env.getProperty("support.email"));
    }


}
