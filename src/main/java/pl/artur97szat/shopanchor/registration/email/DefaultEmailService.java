package pl.artur97szat.shopanchor.registration.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.artur97szat.shopanchor.registration.registrationCode.RegistrationCode;
import pl.artur97szat.shopanchor.registration.registrationCode.RegistrationCodeRepository;
import pl.artur97szat.shopanchor.user.UserRepository;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class DefaultEmailService implements EmailService {


    private final UserRepository userRepository;
    private final RegistrationCodeRepository registrationCodeRepository;

    @Autowired
    public JavaMailSender javaMailSender;

    public DefaultEmailService(UserRepository userRepository, RegistrationCodeRepository registrationCodeRepository) {
        this.userRepository = userRepository;
        this.registrationCodeRepository = registrationCodeRepository;
    }

    @Override
    public void sendEmail(String email, String username, Long id) {
        MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(email);
            helper.setFrom("no-reply@shopanchor.com");
            helper.setSubject("Confirmation ShopAnchor");
            RegistrationCode registrationCode = new RegistrationCode();
            registrationCode.setCode(generateVerificationCode());
            registrationCode.setUser(userRepository.getOne(id));
            registrationCodeRepository.save(registrationCode);
            helper.setText(String.format("Welcome %s to ShopAnchor! %nHere's Your confirmation link: http://localhost:8080/register/details?registrationCode=%s", username, registrationCode.getCode()));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        this.javaMailSender.send(mimeMessage);
    }

    private String generateVerificationCode() {

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String code ="";
        String alphabet = "qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
        List<String> codes = registrationCodeRepository.findAll().stream().map(r -> r.getCode()).collect(Collectors.toList());

        loop:
        for (int i = 0; i < 64; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
            if (i == 63) {
                code = sb.toString();
                if (codes.contains(code)) {
                    i = 0;
                }
            }
        }
        return code;
    }
}
