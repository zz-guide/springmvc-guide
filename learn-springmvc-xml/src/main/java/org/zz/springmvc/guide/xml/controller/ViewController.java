package org.zz.springmvc.guide.xml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/view")
    public String view(Model model) {
        model.addAttribute("msg", "controller 返回一个字符串当做视图名称");
        return "/view/view";
    }

    @GetMapping("/view2")
    public ModelAndView view2(ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "controller 返回 ModelAndView 对象");
        modelAndView.setViewName("/view/view2");
        return modelAndView;
    }
}
