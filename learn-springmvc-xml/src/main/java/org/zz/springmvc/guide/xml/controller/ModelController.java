package org.zz.springmvc.guide.xml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/model")
public class ModelController {

    @GetMapping("/model")
    public String model(Model model) {
        // 可单独传入一个变量
        model.addAttribute("username", "zhangsan");

        // 可直接传入一个map,map的每一对键值对都会分别映射到视图变量上
        Map<String, Object> objectObjectMap = Map.of("id", 1);
        model.addAllAttributes(objectObjectMap);

        return "/model/model";
    }

    @GetMapping("/model2")
    public String model2(ModelMap modelMap) {
        // 直接调用 addAttribute 设置
        modelMap.addAttribute("username", "zhangsan");

        // addAllAttributes
        Map<String, Object> objectObjectMap = Map.of("id", 1);
        modelMap.addAllAttributes(objectObjectMap);

        return "/model/model2";
    }

    @GetMapping("/model3")
    public String model3(Map<String, Object> map) {
        // 直接调用 addAttribute 设置
        map.put("username", "zhangsan");
        return "/model/model3";
    }
}
