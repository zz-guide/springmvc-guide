package org.zz.springmvc.guide.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String list() {
        return "/index";
    }
}
