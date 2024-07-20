package org.zz.springmvc.guide.parameter.controller.params;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zz.springmvc.guide.parameter.ro.User;

/**
 * 1. 记得开启 @MultipartConfig,否则不生效
 */

@Controller
@RequestMapping("/params/post/formData")
@MultipartConfig(maxFileSize=1024000000, maxRequestSize=1024000000,fileSizeThreshold=0)
public class ParamsPostFormDataController {
    @PostMapping(value = "/require")
    public String require(@RequestBody User user) {
        // form-data参数接收需要 @RequestBody 注解，默认必传
        // 经过测试发现，如果是必传情况下，user肯定不为null
        System.out.println("user:" + user);

        return "/ok";
    }

    @PostMapping(value = "/noRequire")
    public String noRequire(@RequestBody(required = false) User user) {
        // form-data参数接收需要 @RequestBody 注解，默认必传
        // 经过测试发现，如果是非必传情况下，user可能为null
        System.out.println("user:" + user);

        return "/ok";
    }

    @PostMapping(value = "/multiParams")
    public String multiParams(@RequestParam("username") String username, @RequestParam("id") Long id) {
        System.out.println("username:" + username);
        System.out.println("id:" + id);

        return "/ok";
    }
}
