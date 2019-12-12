package pl.artur97szat.shopanchor.registration.registrationCode;

import org.springframework.stereotype.Service;

@Service
public class DefaultRegistrationCodeService implements RegistrationCodeService {

    private final RegistrationCodeRepository registrationCodeRepository;

    public DefaultRegistrationCodeService(RegistrationCodeRepository registrationCodeRepository) {
        this.registrationCodeRepository = registrationCodeRepository;
    }

    @Override
    public Long getUsersId(String registrationCode) {
        return registrationCodeRepository.getOne(registrationCode).getUser().getId();
    }

    @Override
    public void deleteRegistrationCode(String registrationCode) {
        registrationCodeRepository.deleteById(registrationCode);
    }

}
