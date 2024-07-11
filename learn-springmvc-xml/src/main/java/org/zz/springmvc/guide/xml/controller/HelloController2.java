package org.zz.springmvc.guide.xml.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("msg", "hello");
        return "hello";
    }
}
