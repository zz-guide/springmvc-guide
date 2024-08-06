package org.zz.springmvc.guide.parameter.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * JsonIgnore 实体类序列化和反序列化的时候忽略该字段字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJsonIgnoreVo{
    @JsonIgnore
    private String username;

    private String name;
}