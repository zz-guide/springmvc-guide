package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 1. @Past 过去的日期
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PastVao {
    @Past(message = "Error Past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date testPast;
}
