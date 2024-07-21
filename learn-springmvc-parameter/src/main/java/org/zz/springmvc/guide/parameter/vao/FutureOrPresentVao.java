package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 1. @FutureOrPresent 将来或者现在的时间
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FutureOrPresentVao {
    @FutureOrPresent(message = "将来或者现在的时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso= DateTimeFormat.ISO.DATE)
    private Date testFutureOrPresent;
}
