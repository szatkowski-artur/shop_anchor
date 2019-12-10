package pl.artur97szat.shopanchor.registration.email;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultEmailServiceTest {

    @Test
    public void properDataToSendEmail_whenSendEmail_userGetsEmail(){
        DefaultEmailService defaultEmailService = new DefaultEmailService();
        defaultEmailService.sendEmail("szatkowski.artur.iii@gmail.com", "Artur", 1l);
    }

}