package pl.artur97szat.shopanchor.registration.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class DefaultEmailService implements EmailService {

    @Autowired
    public JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String email, String username, Long id) {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(email);
            helper.setFrom("no-reply@shopanchor.com");
            helper.setSubject("Confirmation ShopAnchor");
            helper.setText(String.format("Welcome %s to ShopAnchor! %nHere's Your confirmation link: http://localhost:8080/register/details?id=%s", username, id));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        this.javaMailSender.send(mimeMessage);
    }
}
