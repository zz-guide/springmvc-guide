package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.AssertTrue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @AssertTrue 断言值肯定是true
 * 2. @AssertFalse 断言值肯定是false
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssertVao {
    @AssertFalse(message = "falseBoolean 必须是 false")
    private Boolean falseBoolean;

    @AssertTrue(message = "falseBoolean 必须是 true")
    private Boolean trueBoolean;
}
