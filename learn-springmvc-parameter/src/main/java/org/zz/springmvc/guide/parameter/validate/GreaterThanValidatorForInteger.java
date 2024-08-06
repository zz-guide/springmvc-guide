package org.zz.springmvc.guide.parameter.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.zz.springmvc.guide.parameter.validate.annotation.GreaterThan;

public class GreaterThanValidatorForInteger implements ConstraintValidator<GreaterThan, Integer> {

    protected int value;

    @Override
    public void initialize(GreaterThan constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }

        return value > this.value;
    }
}
