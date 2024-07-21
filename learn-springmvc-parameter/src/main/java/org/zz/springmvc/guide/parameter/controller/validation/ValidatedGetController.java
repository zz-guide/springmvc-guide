package org.zz.springmvc.guide.parameter.controller.validation;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zz.springmvc.guide.parameter.vao.*;

@Controller
@RequestMapping("/validated/get")
public class ValidatedGetController {

    @GetMapping("")
    public String index() {
        return "/validated/get/index";
    }

    @GetMapping("/testNumber")
    public String testNumber(@Valid NumberVao numberVao) {
        System.out.println("numberVao:" + numberVao);
        return "/ok";
    }
}
