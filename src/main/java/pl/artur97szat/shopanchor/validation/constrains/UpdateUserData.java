package pl.artur97szat.shopanchor.validation.constrains;

import pl.artur97szat.shopanchor.validation.validators.UpdateUserDataValidatorForUserDataDto;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UpdateUserDataValidatorForUserDataDto.class)
public @interface UpdateUserData {

    String message() default "{pl.artur97szat.shopanchor.validation.constrains.UpdateUserData.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
