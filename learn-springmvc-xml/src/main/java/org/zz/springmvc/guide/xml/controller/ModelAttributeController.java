package org.zz.springmvc.guide.xml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/modelAttribute")
public class ModelAttributeController {

    @ModelAttribute
    public void modelAttributeCommon(Model model){
        // 被 @ModelAttribute 标注的方法会在controller方法调用前调用，用来给Model设置公共属性
        System.out.println("=== 调用 modelAttributeCommon ===");
        model.addAttribute("commonMsg", "公共消息");
    }

    @ModelAttribute
    public String modelAttributeCommon1(){
        System.out.println("=== 调用 modelAttributeCommon1 ===");
        return "返回值";
    }

    @ModelAttribute("defaultAttributeName")
    public String modelAttributeCommon1(ModelMap modelMap){
        System.out.println("=== 调用 modelAttributeCommon1 ===");
        return "返回值2";
    }

    @GetMapping("/t1")
    public String t1(ModelMap modelMap) {
        System.out.println("t1 modelMap:"+modelMap);
        return "/modelAttribute/index";
    }

    @GetMapping("/t2")
    public String t2(ModelMap modelMap) {
        System.out.println("t2 modelMap:"+modelMap);
        return "/modelAttribute/index";
    }
}
