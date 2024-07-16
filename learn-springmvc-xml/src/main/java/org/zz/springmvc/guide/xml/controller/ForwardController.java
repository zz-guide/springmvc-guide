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
@RequestMapping("/forward")
public class ForwardController {

    @GetMapping("/index")
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // servlet 方式转发
        request.getRequestDispatcher("/forward/success").forward(request, response);
    }

    @GetMapping("/index2")
    public String index2() {
        // 转发是一次请求，地址不会变化
        // 通过forward关键字进行转发, 后边跟路由完整地址，不能直接写资源名称，必须由controller转接才行
        return "forward:/forward/success";
    }

    @GetMapping("/success")
    public String success(Model model) {
        System.out.println("=== forward success ===");
        model.addAttribute("msg", "成功跳转");
        return "/forward/success";
    }
}
