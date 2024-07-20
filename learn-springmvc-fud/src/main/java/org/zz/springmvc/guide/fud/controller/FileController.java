package org.zz.springmvc.guide.fud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file")
public class FileController {
    @GetMapping("/uploadIndex")
    public String index() {
        return "/file_upload";
    }
}
