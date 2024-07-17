package org.zz.springmvc.guide.parameter.controller.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zz.springmvc.guide.parameter.ro.User;

@Controller
@RequestMapping("/params/post/applicationJson")
public class PostJsonController {

    @PostMapping(value = "/require")
    public String bodyRequire(@RequestBody User user) {
        // body参数接收需要 @RequestBody 注解，默认必传
        // 经过测试发现，如果是必传情况下，user肯定不为null
        System.out.println("user:" + user);

        return "/ok";
    }

    @PostMapping(value = "/noRequire")
    public String bodyNoRequire(@RequestBody(required = false) User user) {
        // body参数接收需要 @RequestBody 注解，默认必传
        // 经过测试发现，如果是非必传情况下，user可能为null
        System.out.println("user:" + user);

        return "/ok";
    }

    @PostMapping("/multiParams")
    public void bodyMultiParams(@RequestBody String name, @RequestBody Long id) {
        // 使用多个形参接收body 参数
        System.out.println("id:" + id);
        System.out.println("name:" + name);
    }
}
