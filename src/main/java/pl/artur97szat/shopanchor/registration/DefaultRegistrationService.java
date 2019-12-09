package pl.artur97szat.shopanchor.registration;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public void RegisterUser(RegistrationDataDTO registrationData) {

        ModelMapper model = new ModelMapper();
        User user = model.map(registrationData, User.class);
        UserDetails details = model.map(registrationData, UserDetails.class);
        user.setDetails(details);
        user.setActive(Boolean.TRUE);
        user.setPassword(passwordEncoder.encode(registrationData.getPassword()));
        user.getRoles().add(roleRepository.getByName("ROLE_USER"));
        userRepository.save(user);

    }
}
