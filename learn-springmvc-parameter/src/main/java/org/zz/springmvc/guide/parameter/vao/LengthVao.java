package org.zz.springmvc.guide.parameter.vao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * 1. @Length 字符串长度
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LengthVao {
    @Length(min = 1, max = 5, message = "Error Length")
    private String testLength;
}
