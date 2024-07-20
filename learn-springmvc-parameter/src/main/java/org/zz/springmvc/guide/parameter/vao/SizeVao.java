package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 1. @Size 可以用于多种数据类型，不仅仅是字符串。对于字符串，它可以校验长度；对于集合和数组，它可以校验大小。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SizeVao {
    @Size(min = 0, max = 5, message = "Error Size")
    private String testSize;

    @Size(min = 1, max = 5, message = "Error Size")
    private List<String>  testSize2;
}
