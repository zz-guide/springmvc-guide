package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @Null 断言值肯定是true
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NullVao {
    @Null(message = "Error Null")
    private String testNull;
}
