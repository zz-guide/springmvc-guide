package org.zz.springmvc.guide.validation.controller.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/params/post")
public class PostController {

    @GetMapping("")
    public String index() {
        return "/params/post/index";
    }

    @GetMapping("/form_data")
    public String formDataIndex() {
        return "/params/post/post_form_data";
    }

    @GetMapping("/application_json")
    public String applicationJsonIndex() {
        return "/params/post/post_application_json";
    }

    @GetMapping("/urlencoded")
    public String urlEncodedIndex() {
        return "/params/post/post_urlencoded";
    }
}
