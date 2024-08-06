package org.zz.springmvc.guide.parameter.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * JsonAlias 能用在反序列化
 * 只能用来指定别名，没有其他作用
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJsonAliasVo {
    @JsonAlias(value="un")
    private String username;
}
