package org.zz.springmvc.guide.parameter.validate.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.zz.springmvc.guide.parameter.validate.GreaterThanValidatorForInteger;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {GreaterThanValidatorForInteger.class})
public @interface GreaterThan {
    String message() default "must be greater than to {value}";

    int value();

    /**
     * 以下2个方法必须包含，暂时不知道原因
     *
     */
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
