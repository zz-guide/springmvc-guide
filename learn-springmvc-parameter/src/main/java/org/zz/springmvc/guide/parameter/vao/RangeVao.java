package org.zz.springmvc.guide.parameter.vao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

/**
 * 1. @Range 这个注解用于验证数字类型的参数或属性，确保它们的值在指定的范围内。你可以指定最小值（min）和最大值（max）。>= <=
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RangeVao {
    @Range(min = 1, max = 5, message = "Error Range")
    private Long testRange;
}
