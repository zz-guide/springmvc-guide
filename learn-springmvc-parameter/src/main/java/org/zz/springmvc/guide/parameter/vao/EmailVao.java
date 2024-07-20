package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @Email 检查值是不是邮箱类型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailVao {
    @Email(message = "email 不是邮箱格式")
    private String email;
}
