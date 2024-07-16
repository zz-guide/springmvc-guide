package org.zz.springmvc.guide.restful.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zz.springmvc.guide.restful.pojo.User;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @GetMapping("/ajax")
    public void ajax(HttpServletResponse response) throws IOException {
        // 原生servlet api 方式
        PrintWriter writer = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        writer.print("{\"msg\": \"原生servlet api 响应ajax请求\"}");
    }

    @GetMapping(value = "/ajax2")
    @ResponseBody
    public String ajax2() {
        // produces属性来指定响应的内容类型和字符编码, 默认是text/plain;ISO-8859-1;
        // 当使用 @ResponseBody 时，返回结果将不会解析为视图，而是当做字符串直接作为响应
        // text/plain; 响应
        return "{\"msg\": \"原生servlet api 响应ajax请求\"}";
    }

    @GetMapping("/ajax3")
    @ResponseBody
    public User ajax3() {
        // 当使用 @ResponseBody 时，假设返回结果为 一个实体类对象, 响应结果会自动变成json响应
        // application/json; 响应
        // 依赖 jackson-databind jar包，必须引入
        User user = new User();
        user.setUsername("账号");
        user.setPassword("密码");
        return user;
    }
}
