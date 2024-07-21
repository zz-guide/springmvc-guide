package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.Negative;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @Negative 负数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NegativeVao {
    @Negative(message = "负数")
    private Integer testNegative;
}
