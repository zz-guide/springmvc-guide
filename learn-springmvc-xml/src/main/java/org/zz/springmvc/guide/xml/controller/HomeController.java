package org.zz.springmvc.guide.xml.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

    // "","/"，"/index" 都可以
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("msg", "欢迎进入 home.jsp");
        // 此处的字符串其实就是映射一个jsp的文件名称
        return "/home";
    }

    @GetMapping("/index")
    public ModelAndView index1(HttpServletRequest req, HttpServletResponse resp, Model model) {
        // 虽然能直接获取到servlet的req，resp对象,但不建议使用，因为太繁琐了
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "欢迎进入 home/index.jsp");
        mv.setViewName("/home/index");
        return mv;
    }
}
