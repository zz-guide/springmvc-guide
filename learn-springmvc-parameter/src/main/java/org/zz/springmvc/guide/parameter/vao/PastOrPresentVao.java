package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 1. @PastOrPresent 过去或者现在的时间
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PastOrPresentVao {
    @PastOrPresent(message = "过去或者现在的时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date testPastOrPresent;
}
