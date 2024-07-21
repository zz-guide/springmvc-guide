package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @PositiveOrZero 0或者正数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositiveOrZeroVao {
    @PositiveOrZero(message = "0或者正数")
    private Integer testPositiveOrZero;
}
