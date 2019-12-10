package pl.artur97szat.shopanchor.validation.validators;

import pl.artur97szat.shopanchor.registration.first.FirstRegistrationDataDTO;
import pl.artur97szat.shopanchor.validation.constrains.RetypePassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RetypePasswordValidatorForString implements ConstraintValidator<RetypePassword, FirstRegistrationDataDTO> {
    @Override
    public void initialize(RetypePassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(FirstRegistrationDataDTO registrationDataDTO, ConstraintValidatorContext constraintValidatorContext) {
        return registrationDataDTO.getPassword().equals(registrationDataDTO.getRePassword());
    }
}
