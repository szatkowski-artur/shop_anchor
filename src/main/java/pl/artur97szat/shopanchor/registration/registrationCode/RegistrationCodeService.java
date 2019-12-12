package pl.artur97szat.shopanchor.registration.registrationCode;

public interface RegistrationCodeService {
    Long getUsersId(String registrationCode);

    void deleteRegistrationCode(String registrationCode);
}
