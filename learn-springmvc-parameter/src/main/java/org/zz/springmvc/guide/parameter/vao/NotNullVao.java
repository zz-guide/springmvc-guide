package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @NotNull 断言值肯定是false
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotNullVao {
    @NotNull(message = "Error NonNull")
    private String testNonNull;
}
