package org.zz.springmvc.guide.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @PostMapping("/test")
    public String test() {
       return "/ok";
    }
}
