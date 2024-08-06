package org.zz.springmvc.guide.parameter.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * JsonFormat 专门用于序列化和反序列化格式化日期时间字段
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJsonFormatVo {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
}
