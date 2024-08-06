package org.zz.springmvc.guide.parameter.desensitization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.NoArgsConstructor;
import org.zz.springmvc.guide.parameter.desensitization.annotation.MaskingData;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Pattern;

@NoArgsConstructor
public class MaskingDataSerializer extends JsonSerializer<String> implements ContextualSerializer {

    private Pattern patten;

    private String replace;

    public MaskingDataSerializer(Pattern patten, String replace) {
        this.patten = patten;
        this.replace = replace;
    }

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        if (patten != null && replace != null) {
            // 参数齐全就格式化后输出
            jsonGenerator.writeString(replaceStr(value));
            return;
        }

        // 参数不齐全，直接输出
        jsonGenerator.writeString(value);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        if (beanProperty == null) {
            return this;
        }

        // 只处理String 类型
        if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {
            MaskingData sensitiveInfo = beanProperty.getAnnotation(MaskingData.class);
            if (sensitiveInfo == null) {
                sensitiveInfo = beanProperty.getContextAnnotation(MaskingData.class);
            }

            // 如果能得到注解，就将注解的就构造一个新的 serializer
            if (sensitiveInfo != null) {
                return new MaskingDataSerializer(Pattern.compile(sensitiveInfo.patten()), sensitiveInfo.replace());
            }
        }
        return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
    }

    private String replaceStr(String str) {
        if (str == null) {
            return null;
        }
        return patten.matcher(str)
                .replaceAll(replace);
    }
}