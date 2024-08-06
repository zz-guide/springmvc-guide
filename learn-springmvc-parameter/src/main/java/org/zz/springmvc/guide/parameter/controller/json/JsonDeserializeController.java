package org.zz.springmvc.guide.parameter.controller.json;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.zz.springmvc.guide.parameter.vo.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/json_deserialize")
public class JsonDeserializeController {

    @PostMapping(value = "/JsonProperty")
    public UserJsonPropertyVo testJsonProperty(@RequestBody UserJsonPropertyVo userJsonPropertyVo) {
        System.out.println("userJsonPropertyVo:"+userJsonPropertyVo);
        return userJsonPropertyVo;
    }

    @PostMapping(value = "/JsonAlias")
    public UserJsonAliasVo testJsonAlias(@RequestBody UserJsonAliasVo userJsonAliasVo) {
        System.out.println("userJsonAliasVo:"+userJsonAliasVo);

        return userJsonAliasVo;
    }

    @PostMapping(value = "/JsonIgnore")
    public UserJsonIgnoreVo testJsonIgnore(@RequestBody UserJsonIgnoreVo userJsonIgnoreVo) {
        System.out.println("userJsonIgnoreVo:"+userJsonIgnoreVo);

        return userJsonIgnoreVo;
    }

    @PostMapping(value = "/JsonFormat")
    public UserJsonFormatVo testJsonFormat(@RequestBody UserJsonFormatVo userJsonFormatVo) {
        System.out.println("userJsonFormatVo:"+userJsonFormatVo);

        return userJsonFormatVo;
    }

    @PostMapping(value = "/DateTimeFormat")
    public UserDateTimeFormatVo testJsonFormat(@RequestBody UserDateTimeFormatVo userDateTimeFormatVo) {
        System.out.println("userDateTimeFormatVo:"+userDateTimeFormatVo);

        return userDateTimeFormatVo;
    }

    @PostMapping(value = "/DateTimeFormat2")
    public UserDateTimeFormatVo testJsonFormat2(@RequestParam(name = "birthday")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime birthday) {
        System.out.println("birthday:"+birthday);

        return new UserDateTimeFormatVo();
    }
}
