package pl.artur97szat.shopanchor.validation.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.artur97szat.shopanchor.user.UserRepository;
import pl.artur97szat.shopanchor.validation.constrains.EmailDb;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailDBValidatorForString implements ConstraintValidator<EmailDb, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(EmailDb constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return userRepository.getByEmail(s).isEmpty();
    }
}