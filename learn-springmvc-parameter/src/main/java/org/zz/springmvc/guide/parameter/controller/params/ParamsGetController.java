package org.zz.springmvc.guide.parameter.controller.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zz.springmvc.guide.parameter.ro.User;

/**
 * 1. 旧版本不加 @RequestParam 也能进行正确映射，新版本会报错，以防万一之后的参数都默认加上该注解。
 * 2. required=false的时候最好设置下defaultValue, required=true不用设置defaultValue
 */

@Controller
@RequestMapping("/params/get")
public class ParamsGetController {

    @GetMapping("")
    public String index() {
        return "/params/get/index";
    }

    @GetMapping("/noRequireAndNoDefaultValue")
    public String noRequireAndNoDefaultValue(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "id", required = false) Long id
    ) {
        System.out.println("=== 非必传，无默认值 ===");
        System.out.println("id:" + id); // null
        System.out.println("username:" + username); // null

        return "/ok";
    }

    @GetMapping("/noRequire")
    public String noRequire(
            @RequestParam(value = "username", required = false, defaultValue = "") String username,
            @RequestParam(value = "id", required = false, defaultValue = "345") Long id
    ) {
        System.out.println("=== 非必传，有默认值 ===");
        System.out.println("id:" + id); // 345
        System.out.println("username:" + username); // ""

        return "/ok";
    }

    @GetMapping("/require")
    public String require(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "id") Long id
    ) {
        System.out.println("=== 必传, 如果没有对应参数，则直接抛出异常 ===");
        System.out.println("id:" + id);
        System.out.println("username:" + username);

        return "/ok";
    }

    @GetMapping("/pojo")
    public String pojo(User user) {
        // 使用实体对象接收参数
        // 不需要加 @RequestParam
        // 若参数名称与实体类对象的属性名称相同，则可以自动绑定
        // 若不传或者名称不匹配，则为对应类型的默认值null
        // user对象必然存在，不会是null
        System.out.println("=== 实体类接收 ===");
        System.out.println("user:" + user);
        return "/ok";
    }
}
