package org.zz.springmvc.guide.parameter.vao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.BindParam;

/**
 * 1. @BindParam 断言值肯定是true
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AliasVao {
    @BindParam(value = "name_alias")
    private String name;
}
