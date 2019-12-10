package pl.artur97szat.shopanchor.registration.email;

public interface EmailService {

    void sendEmail(String email, String username, Long id);

}
