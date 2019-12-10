package pl.artur97szat.shopanchor.registration.first;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.artur97szat.shopanchor.registration.email.EmailService;
import pl.artur97szat.shopanchor.role.RoleRepository;
import pl.artur97szat.shopanchor.user.User;
import pl.artur97szat.shopanchor.user.UserRepository;
import pl.artur97szat.shopanchor.userDetails.UserDetails;

@Service
@Transactional
public class DefaultRegistrationService implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final EmailService emailService;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository, EmailService emailService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.emailService = emailService;
    }


    @Override
    public void RegisterUser(FirstRegistrationDataDTO registrationData) {

        ModelMapper model = new ModelMapper();
        User user = model.map(registrationData, User.class);
        //        TODO obsługa powtórzeń maila i username
        user.setActive(Boolean.FALSE);
        user.setPassword(passwordEncoder.encode(registrationData.getPassword()));
        user.getRoles().add(roleRepository.getByName("ROLE_USER"));
        UserDetails userDetails = new UserDetails();
        userDetails.setOwner(user);
        user.setDetails(userDetails);
        userRepository.save(user);
        emailService.sendEmail(registrationData.getEmail(), registrationData.getUsername(), user.getId());

    }

}
