package pl.artur97szat.shopanchor.validation.constrains;

import pl.artur97szat.shopanchor.validation.validators.EmailDBValidatorForString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailDBValidatorForString.class)
public @interface EmailDb {

    String message() default "{pl.artur97szat.shopanchor.validation.constrains.EmailDB.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
