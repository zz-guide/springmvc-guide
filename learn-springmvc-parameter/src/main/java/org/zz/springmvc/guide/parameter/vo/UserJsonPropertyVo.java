package org.zz.springmvc.guide.parameter.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JsonProperty 能用在序列化和反序列化
 * defaultValue：json字符串转对象的时候使用
 * index: 数字越大，字段显示越靠前
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJsonPropertyVo {
    @JsonProperty(value="un")
    private String username;

    @JsonProperty(value="pass", defaultValue = "123456")
    @JsonDeserialize()
    private String password;

    @JsonProperty(index = 10)
    private String name;
}
