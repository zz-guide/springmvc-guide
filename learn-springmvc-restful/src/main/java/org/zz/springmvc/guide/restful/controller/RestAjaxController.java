package org.zz.springmvc.guide.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zz.springmvc.guide.restful.pojo.User;


@RestController
@RequestMapping("/restAjax")
public class RestAjaxController {

    @GetMapping(value = "/ajax2", produces = "text/json;charset=UTF-8")
    public String ajax2() {
        return "{\"msg\": \"原生servlet api 响应ajax请求\"}";
    }

    @GetMapping("/ajax3")
    public User ajax3() {
        User user = new User();
        user.setUsername("账号");
        user.setPassword("密码");
        return user;
    }
}
