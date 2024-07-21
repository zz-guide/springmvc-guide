package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @Positive 整数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositiveVao {
    @Positive(message = "整数")
    private Integer testPositive;
}
