package org.zz.springmvc.guide.parameter.vao;

import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 1. @Future 将来的日期
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FutureVao {
    @Future(message = "Error Future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date testFuture;
}
