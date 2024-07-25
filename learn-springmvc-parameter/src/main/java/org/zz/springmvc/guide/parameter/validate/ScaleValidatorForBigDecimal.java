package org.zz.springmvc.guide.parameter.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.zz.springmvc.guide.parameter.validate.annotation.Scale;

import java.math.BigDecimal;

public class ScaleValidatorForBigDecimal implements ConstraintValidator<Scale, BigDecimal> {

    protected int scaleMax;

    protected int scaleMin;


    @Override
    public void initialize(Scale constraintAnnotation) {
        this.scaleMax = constraintAnnotation.max();
        this.scaleMin = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(BigDecimal value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        int scale = value.scale();
        return scaleMin <= scale && scale <= scaleMax;
    }
}
