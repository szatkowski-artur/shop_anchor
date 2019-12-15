package pl.artur97szat.shopanchor.utils;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.artur97szat.shopanchor.role.Role;
import pl.artur97szat.shopanchor.role.RoleRepository;
import pl.artur97szat.shopanchor.user.User;
import pl.artur97szat.shopanchor.user.UserRepository;

@Component @Profile("heroku")
public class HerokuStarterData implements ApplicationRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public HerokuStarterData(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Role role = new Role();
        role.setName("ROLE_USER");
        role.setId(1l);
        roleRepository.save(role);

        User user = new User();
        user.getRoles().add(role);
        user.setUsername("username");
        user.setEmail("email@email.com");
        user.setPassword(passwordEncoder.encode( "Qwerty123"));
        user.setActive(true);
        userRepository.save(user);

    }
}
