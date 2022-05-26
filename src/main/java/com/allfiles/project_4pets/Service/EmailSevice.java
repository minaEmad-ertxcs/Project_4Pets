package com.allfiles.project_4pets.Service;

import com.allfiles.project_4pets.Entity.User;
import com.allfiles.project_4pets.Entity.VerificationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSevice {
    private final VerificationTokenService verificationTokenService;
    private  final TemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;
@Autowired
    public EmailSevice(VerificationTokenService verificationTokenService, TemplateEngine templateEngine, JavaMailSender javaMailSender) {
        this.verificationTokenService = verificationTokenService;
    this.templateEngine = templateEngine;
    this.javaMailSender = javaMailSender;
}
    public void sendemail(User user)throws MessagingException {
        VerificationToken verificationToken=verificationTokenService.findbyuser(user);
        if (verificationToken !=null){
            String token =verificationToken.getToken();
            Context context=new Context();
            context.setVariable("title","verfiy your email address");
            context.setVariable("link","http://localhost/activation?token");
            String body=templateEngine.process("verification",context);
            MimeMessage message=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setTo(user.getEmail());
            helper.setSubject("email address verification");
            helper.setText(body,true);
            javaMailSender.send(message);
        }
    }

}
