package org.zz.springmvc.guide.parameter.controller.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/params/post")
public class ParamsPostController {

    @GetMapping("")
    public String index() {
        return "/params/post/index";
    }

    @GetMapping("/multipart_form_data")
    public String formDataIndex() {
        return "/params/post/multipart_form_data";
    }

    @GetMapping("/application_json")
    public String applicationJsonIndex() {
        return "/params/post/application_json";
    }

    @GetMapping("/urlencoded")
    public String urlEncodedIndex() {
        return "/params/post/urlencoded";
    }
}
