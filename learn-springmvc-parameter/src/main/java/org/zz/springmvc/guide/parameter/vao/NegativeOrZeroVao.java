package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.NegativeOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @NegativeOrZero 0或者负数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NegativeOrZeroVao {
    @NegativeOrZero(message = "0或者负数")
    private Integer testNegativeOrZero;
}
