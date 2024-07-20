package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 1. 不加@NotNull的话，只有传参的时候才会校验，不传就是null
 * 2. @Min @Max可以变相实现 > < 关系，同理还有@DecimalMax @DecimalMin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberVao {
    @Min(value = 1, message = "min 最小是1")
    private Long min;

    @Max(value = 10, message = "max 最大是 10")
    private Long max;

    @Digits(integer = 2, fraction = 3, message = "Error Dig")
    private BigDecimal dig;

    @DecimalMax(value = "10", message = "decimalMax 最大是10")
    private String decimalMax;

    @DecimalMin(value = "1", message = "decimalMin 最小是1")
    private String decimalMin;
}
