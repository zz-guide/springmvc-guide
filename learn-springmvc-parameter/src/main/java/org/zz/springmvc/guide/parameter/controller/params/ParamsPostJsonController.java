package org.zz.springmvc.guide.parameter.controller.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zz.springmvc.guide.parameter.ro.User;

@Controller
@RequestMapping("/params/post/applicationJson")
public class ParamsPostJsonController {

    @PostMapping(value = "/require")
    public String require(@RequestBody User user) {
        // body参数接收需要 @RequestBody 注解，默认必传
        // 经过测试发现，如果是必传情况下，user肯定不为null
        System.out.println("user:" + user);
        return "/ok";
    }

    @PostMapping(value = "/noRequire")
    public String noRequire(@RequestBody(required = false) User user) {
        // body参数接收需要 @RequestBody 注解，默认必传
        // 一旦被 @RequestBody 修饰，body不传的话就是null
        // 经过测试发现，如果是非必传情况下，user可能为null
        // 如果body是null,那么 user就是null
        // 如果body是空{},那么user就不是null
        System.out.println("user:" + user);

        return "/ok";
    }

    @PostMapping("/multiParams")
    public void multiParams(@RequestBody String username, @RequestBody Long id) {
        System.out.println("===  使用多个形参接收body 参数, 默认不支持 ===");
        System.out.println("id:" + id);
        System.out.println("username:" + username);
    }
}
