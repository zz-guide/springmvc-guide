package org.zz.springmvc.guide.parameter.controller.json;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zz.springmvc.guide.parameter.dto.resp.UserRespDTO;
import org.zz.springmvc.guide.parameter.vo.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/json_serialize")
public class JsonSerializeController {

    @GetMapping(value = "/JsonProperty")
    public UserJsonPropertyVo testJsonProperty() {
        UserJsonPropertyVo userVo = new UserJsonPropertyVo();
        userVo.setUsername("zz123456");
        userVo.setName("名字");

        return userVo;
    }

    @GetMapping(value = "/JsonAlias")
    public UserJsonAliasVo testJsonAlias() {
        UserJsonAliasVo userVo = new UserJsonAliasVo();
        userVo.setUsername("zz123456");

        return userVo;
    }

    @GetMapping(value = "/JsonIgnore")
    public UserJsonIgnoreVo testJsonIgnore() {
        UserJsonIgnoreVo userVo = new UserJsonIgnoreVo();
        userVo.setUsername("zz123456");
        userVo.setName("name");

        return userVo;
    }

    @GetMapping(value = "/JsonFormat")
    public UserJsonFormatVo testJsonFormatVo() {
        UserJsonFormatVo userVo = new UserJsonFormatVo();
        userVo.setBirthday(Date.from(LocalDateTime.of(2024, 8, 6, 12,12,12).atZone(ZoneId.systemDefault()).toInstant()));

        return userVo;
    }

    @GetMapping(value = "/DateTimeFormat")
    public UserDateTimeFormatVo testDateTimeFormat() {
        UserDateTimeFormatVo userDateTimeFormatVo = new UserDateTimeFormatVo();
        userDateTimeFormatVo.setBirthday(LocalDateTime.of(2024, 8, 6, 12,12,12));

        return userDateTimeFormatVo;
    }

    @GetMapping(value = "/testMySerialize")
    public UserRespDTO testMySerialize() {
        /**
         * 自定义脱敏注解，序列化为json的生效
         */
        UserRespDTO userRespDTO = new UserRespDTO();
        userRespDTO.setUsername("zz123456");
        userRespDTO.setPhoneNo("18435186784");
        userRespDTO.setPassword("123456");
        userRespDTO.setIdNo("153337188328745467");
        userRespDTO.setFullName("张张李四");
        userRespDTO.setBankCardNo("6212243567899001");
        return userRespDTO;
    }
}
