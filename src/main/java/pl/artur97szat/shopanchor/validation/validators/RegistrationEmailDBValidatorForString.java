package pl.artur97szat.shopanchor.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.artur97szat.shopanchor.user.UserRepository;
import pl.artur97szat.shopanchor.validation.constrains.RegistrationEmailDb;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegistrationEmailDBValidatorForString implements ConstraintValidator<RegistrationEmailDb, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(RegistrationEmailDb constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.getByEmail(s).isEmpty();
    }
}
