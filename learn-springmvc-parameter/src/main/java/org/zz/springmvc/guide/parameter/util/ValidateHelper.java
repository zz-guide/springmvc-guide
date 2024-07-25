package org.zz.springmvc.guide.parameter.util;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class ValidateHelper {

//    private final Validator validator;

    /**
     * 校验对象
     *
     * @param bean
     * @param groups 分组
     */
    public void validate(Object bean, Class... groups) {
//        Set<ConstraintViolation<Object>> validate = validator.validate(bean, groups);
//        validate.stream()
//                .map(ConstraintViolation::getMessage)
//                .findFirst()
//                .ifPresent(m -> {
//
//                });

    }
}
