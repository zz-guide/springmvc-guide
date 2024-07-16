package org.zz.springmvc.guide.restful.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionAnnotationController {

    @ExceptionHandler
    public String tip(Exception e, Model model) {
        model.addAttribute("e", e);

        System.out.println("=== exception ===");
       return "/tip";
    }
}
