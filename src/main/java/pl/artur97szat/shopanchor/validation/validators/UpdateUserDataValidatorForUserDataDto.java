package pl.artur97szat.shopanchor.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.artur97szat.shopanchor.user.User;
import pl.artur97szat.shopanchor.user.UserDataDto;
import pl.artur97szat.shopanchor.user.UserRepository;
import pl.artur97szat.shopanchor.validation.constrains.UpdateUserData;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UpdateUserDataValidatorForUserDataDto implements ConstraintValidator<UpdateUserData, UserDataDto> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(UpdateUserData constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserDataDto userDataDto, ConstraintValidatorContext constraintValidatorContext) {
        Long id = userDataDto.getId();
        Long idUsername = userRepository.getByUsername(userDataDto.getUsername()).map(User::getId).orElse(id);
        Long idEmail = userRepository.getByEmail(userDataDto.getEmail()).map(User::getId).orElse(id);
        return id == idUsername && id == idEmail;
    }
}
