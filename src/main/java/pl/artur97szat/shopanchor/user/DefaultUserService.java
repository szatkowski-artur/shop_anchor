package pl.artur97szat.shopanchor.user;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.artur97szat.shopanchor.userDetails.UserDetailsRepository;
import pl.artur97szat.shopanchor.utils.Username;

import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final ModelMapper mapper;

    public DefaultUserService(UserRepository userRepository, UserDetailsRepository userDetailsRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
        this.mapper = modelMapper;
    }

    @Override
    public UserDataDto getAllUsersData(){

        User user = userRepository.getByUsername(Username.get()).get();
        UserDataDto userDataDto = Optional.ofNullable(user.getDetails())
                .map(d -> mapper.map(d, UserDataDto.class))
                .orElse(new UserDataDto());

        userDataDto.setEmail(user.getEmail());
        userDataDto.setUsername(user.getUsername());

        return userDataDto;

    }

}
