package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @NotEmpty表示自身不为空就行，比如空格的话不算空
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotEmptyVao {
    @NotEmpty(message = "name 自身不能为空")
    private String name;
}
