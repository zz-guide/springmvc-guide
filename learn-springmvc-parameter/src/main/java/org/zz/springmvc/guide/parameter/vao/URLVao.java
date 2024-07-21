package org.zz.springmvc.guide.parameter.vao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.URL;

/**
 * 1. @URL 判断是不是一个url
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class URLVao {
    @URL(message = "不是一个url")
    private String testUrl;
}
