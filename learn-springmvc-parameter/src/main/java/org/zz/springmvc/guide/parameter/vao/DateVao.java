package org.zz.springmvc.guide.parameter.vao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateVao {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date testDate;
}
