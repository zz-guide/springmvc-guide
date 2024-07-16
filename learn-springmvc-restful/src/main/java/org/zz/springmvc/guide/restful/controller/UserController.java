package org.zz.springmvc.guide.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.zz.springmvc.guide.restful.pojo.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/ok")
    public String ok() {
        System.out.println("=== 进入 user/ok ===");
        return "ok";
    }

    @GetMapping("/list")
    public String list() {
        System.out.println("正在查询用户信息");
        return "/ok";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") String id) {
        System.out.println("正在通过id查询用户信息,id:"+id);
        return "/ok";
    }

    @PostMapping("/save")
    public String save(User user) {
        System.out.println("新增用户信息,user:"+user);
        return "/ok";
    }

    @PutMapping("/update")
    public String update(User user) {
        System.out.println("修改用户信息,user:"+user);
        // put 请求无法直接跳转到jsp，且不支持转发，只能重定向
        return "redirect:/user/ok";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") String id) {
        System.out.println("正在通过id删除用户信息,id:"+id);
        return "redirect:/user/ok";
    }
}
