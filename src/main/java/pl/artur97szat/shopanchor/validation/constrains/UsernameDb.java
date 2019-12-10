package pl.artur97szat.shopanchor.validation.constrains;

import pl.artur97szat.shopanchor.validation.validators.UsernameDBValidatorForString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameDBValidatorForString.class)
public @interface UsernameDb {

    String message() default "{pl.artur97szat.shopanchor.validation.constrains.UsernameDB.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
