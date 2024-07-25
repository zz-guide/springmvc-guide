package org.zz.springmvc.guide.parameter.desensitization.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.zz.springmvc.guide.parameter.desensitization.MaskingDataSerializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = MaskingDataSerializer.class)
public @interface MaskingData {

    /**
     * 匹配正则
     *
     * @return
     */
    String patten();

    /**
     * 替换字符
     *
     * @return
     */
    String replace() default "*";


}
