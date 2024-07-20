package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @Pattern 正则表达式校验
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatternVao {
    @Pattern(regexp = "^\\d+", message = "Error Pattern")
    private String testPattern;
}
