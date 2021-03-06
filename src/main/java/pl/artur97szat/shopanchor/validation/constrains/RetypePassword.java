package pl.artur97szat.shopanchor.validation.constrains;

import pl.artur97szat.shopanchor.validation.validators.RetypePasswordValidatorForFirstRegistrationDataDTO;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RetypePasswordValidatorForFirstRegistrationDataDTO.class)
public @interface RetypePassword {

    String message() default "{pl.artur97szat.shopanchor.validation.constrains.RetypePassword.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};



}
