package pl.artur97szat.shopanchor.validation.constrains;

import pl.artur97szat.shopanchor.validation.validators.AddProductShopTypeValidatorForString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AddProductShopTypeValidatorForString.class)
public @interface IsShopImplemented {

    String message() default "{pl.artur97szat.shopanchor.validation.constrains.IsShopImplemented.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
