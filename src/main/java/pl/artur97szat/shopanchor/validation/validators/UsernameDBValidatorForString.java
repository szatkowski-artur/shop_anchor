package pl.artur97szat.shopanchor.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.artur97szat.shopanchor.user.UserRepository;
import pl.artur97szat.shopanchor.validation.constrains.UsernameDb;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameDBValidatorForString implements ConstraintValidator<UsernameDb, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(UsernameDb constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.getByUsername(s).isEmpty();
    }
}
