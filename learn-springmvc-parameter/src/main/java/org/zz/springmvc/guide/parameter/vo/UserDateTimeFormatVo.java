package org.zz.springmvc.guide.parameter.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * DateTimeFormat
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDateTimeFormatVo {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime birthday;
}
