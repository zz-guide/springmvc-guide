package org.zz.springmvc.guide.xml.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/domain")
@SessionAttributes(value = {"anno_msg"})
public class DomainController {

    @GetMapping("/session")
    public String session(HttpSession httpSession) {
        httpSession.setAttribute("msg", "HttpSession 域");
        return "/domain/session";
    }

    @GetMapping("/session2")
    public String session2(Model model) {
        model.addAttribute("anno_msg", "@SessionAttributes注解 设置参数");
        return "/domain/session2";
    }

    @GetMapping("/application")
    public String application(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("msg", "ServletContext 设置域参数");
        return "/domain/application";
    }
}
