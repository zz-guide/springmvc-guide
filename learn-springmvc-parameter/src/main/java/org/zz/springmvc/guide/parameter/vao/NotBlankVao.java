package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @NotBlank 其实已经包含了@NotNull的功能了
 * 2. @NotBlank 表示trim之后仍然不能为空，比如空格也当做空对待
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotBlankVao {
    @NotBlank(message = "username 不能为空")
    private String username;
}
