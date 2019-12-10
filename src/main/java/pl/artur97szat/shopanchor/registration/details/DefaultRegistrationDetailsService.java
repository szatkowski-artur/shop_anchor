package pl.artur97szat.shopanchor.registration.details;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.artur97szat.shopanchor.user.User;
import pl.artur97szat.shopanchor.user.UserRepository;
import pl.artur97szat.shopanchor.userDetails.UserDetails;
import pl.artur97szat.shopanchor.userDetails.UserDetailsRepository;

@Service
public class DefaultRegistrationDetailsService implements RegistrationDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    private final UserRepository userRepository;

    public DefaultRegistrationDetailsService(UserDetailsRepository userDetailsRepository, UserRepository userRepository) {
        this.userDetailsRepository = userDetailsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addUserDetails(DetailsRegistrationDataDTO userDetailsDTO) {
        ModelMapper modelMapper = new ModelMapper();
        UserDetails userDetails = modelMapper.map(userDetailsDTO, UserDetails.class);
        userDetails.setId(userDetailsRepository.getByOwnerId(userDetailsDTO.getOwner()).getId());
        userDetails.setOwner(userRepository.getById(userDetailsDTO.getOwner()));
        userDetailsRepository.save(userDetails);
    }

    @Override
    public void confirmUser(Long id) {
        User user = userRepository.getById(id);
        user.setActive(Boolean.TRUE);
        userRepository.save(user);
    }
}
