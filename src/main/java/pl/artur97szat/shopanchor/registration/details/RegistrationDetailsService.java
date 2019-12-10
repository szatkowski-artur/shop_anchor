package pl.artur97szat.shopanchor.registration.details;

import pl.artur97szat.shopanchor.registration.details.DetailsRegistrationDataDTO;

public interface RegistrationDetailsService {

    void addUserDetails(DetailsRegistrationDataDTO userDetails);

    void confirmUser(Long id);
}
