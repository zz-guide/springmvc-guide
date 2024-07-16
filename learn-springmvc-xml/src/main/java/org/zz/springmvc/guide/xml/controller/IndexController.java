package org.zz.springmvc.guide.xml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexView(Model model) {
        model.addAttribute("msg", "欢迎进入 index.jsp");
        // 此处的字符串其实就是映射一个jsp的文件名称
        return "/index";
    }
}
