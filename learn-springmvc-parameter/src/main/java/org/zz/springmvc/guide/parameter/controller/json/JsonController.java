package org.zz.springmvc.guide.parameter.controller.json;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zz.springmvc.guide.parameter.ro.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JsonController {

    @GetMapping(value = "/string", produces = "application/json")
    public String stringJson() {
        return "{\"msg\":\"返回值是json字符串，但需要用 produces 约束\"}";
    }

    @GetMapping(value = "/map")
    public Map<?, ?> mapJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "返回值是map对象[发现不加  @ResponseBody 也能正常返回json, 说明是springboot的默认行为]");
        return map;
    }

    @GetMapping(value = "/demoData")
    public User demoDataJson() {
        User user = new User();
        user.setId(1L);
        user.setUsername("返回值是 User 对象");
        return user;
    }

    @GetMapping(value = "/stringArray")
    public String[] stringArrayJson() {
        return new String[]{"返回一个字符串数组", "world"};
    }

    @GetMapping(value = "/list")
    public List<?> listJson() {
        return List.of("返回一个list", "world");
    }

    @GetMapping(value = "/object")
    public Object objectJson() {
        User user = new User();
        user.setId(1L);
        user.setUsername("返回值是 Object 对象");

        return user;
    }
}
