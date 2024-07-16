package org.zz.springmvc.guide.xml.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

    @GetMapping("/index")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 考虑到url上可能会自定义部署路径， 所以使用相对地址
        response.sendRedirect("success");
    }

    @GetMapping("/index2")
    public String index2() {
        // 重定向是多次请求，地址会变
        return "redirect:/redirect/success";
    }

    @GetMapping("/index3")
    public String index3() {
        // 重定向到外网地址
        return "redirect:https://www.baidu.com/";
    }

    @GetMapping("/success")
    public String success(Model model) {
        model.addAttribute("msg", "成功跳转");
        return "/redirect/success";
    }
}
