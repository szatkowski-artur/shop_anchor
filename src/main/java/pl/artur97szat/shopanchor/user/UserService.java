package pl.artur97szat.shopanchor.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {


    UserDataDto getAllUsersData();

    void updateUserData(UserDataDto userDataDto);
}
