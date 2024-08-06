package org.zz.springmvc.guide.parameter.vao.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zz.springmvc.guide.parameter.validate.annotation.GreaterThan;

/**
 * 1. 测试自定义注解校验规则
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyVao {
    @GreaterThan(value = 3)
    private Integer number;
}
