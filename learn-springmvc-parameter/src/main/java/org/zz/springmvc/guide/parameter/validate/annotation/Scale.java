package org.zz.springmvc.guide.parameter.validate.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.zz.springmvc.guide.parameter.validate.ScaleValidatorForBigDecimal;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(Scale.List.class)
@Documented
@Constraint(validatedBy = {ScaleValidatorForBigDecimal.class})
public @interface Scale {

    String message() default "精度不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 最大精度 (包含等于)
     *
     * @return
     */
    int max() default Integer.MAX_VALUE;

    /**
     * 最小精度 (包含等于)
     *
     * @return
     */
    int min() default 0;


    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        Scale[] value();
    }


}
