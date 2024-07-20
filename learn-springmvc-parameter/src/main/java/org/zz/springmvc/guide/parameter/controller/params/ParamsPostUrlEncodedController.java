package org.zz.springmvc.guide.parameter.controller.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zz.springmvc.guide.parameter.ro.User;

@Controller
@RequestMapping("/params/post/urlEncoded")
public class ParamsPostUrlEncodedController {
    @PostMapping(value = "/require")
    public String require(User user) {
        // @RequestBody 默认只接受json和xml形式的数据，所以这里不适合加
        // 经过测试发现，如果是必传情况下，user肯定不为null
        System.out.println("user:" + user);

        return "/ok";
    }

    @PostMapping(value = "/noRequire")
    public String noRequire(User user) {
        // 当什么注解也没有的时候，user对象始终存在
        System.out.println("user:" + user);
        return "/ok";
    }

    @PostMapping(value = "/multiParams")
    public String multiParams(@RequestParam("username") String username, @RequestParam("id") Long id) {
        // 经过测试发现 @RequestParam 在 post方式请求的时候 会合并url以及body上的同名参数（字符串类型是这种表现，数字类型以url参数为准），并以逗号分作为新字符串值
        // 所以传递参数的时候一定避免这种混乱情况
        System.out.println("username:" + username);
        System.out.println("id:" + id);
        return "/ok";
    }
}
