package pl.artur97szat.shopanchor.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.artur97szat.shopanchor.user.UserRepository;
import pl.artur97szat.shopanchor.validation.constrains.RegistrationUsernameDb;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegistrationUsernameDBValidatorForString implements ConstraintValidator<RegistrationUsernameDb, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(RegistrationUsernameDb constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.getByUsername(s).isEmpty();
    }
}
