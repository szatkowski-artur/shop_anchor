package pl.artur97szat.shopanchor.validation.validators;

import pl.artur97szat.shopanchor.shop.ShopType;
import pl.artur97szat.shopanchor.validation.constrains.IsShopImplemented;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AddProductShopTypeValidatorForString implements ConstraintValidator<IsShopImplemented, String> {

    @Override
    public void initialize(IsShopImplemented constraintAnnotation) {

    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext constraintValidatorContext) {

        return ShopType.existByUrl(url);

    }
}
