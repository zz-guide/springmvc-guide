package org.zz.springmvc.guide.parameter.controller.params;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zz.springmvc.guide.parameter.ro.FormData;

@Controller
@RequestMapping("/params/post/formData")
public class ParamsPostFormDataController {
    @PostMapping(value = "/t1")
    public String t1(@RequestParam(value = "file", required = false) MultipartFile file) {
        // 经过测试发现，对于 multipart/form-data 类型，如果形参只有一个MultipartFile，则必须用@RequestParam 修饰，multipartResolver 不是必须的
        if (file == null || file.isEmpty()) {
            System.out.println("文件参数为空");
        } else {
            System.out.println("文件参数不为空");
        }

        return "/ok";
    }

    @PostMapping(value = "/t2")
    public String t2(@RequestParam(value = "file", required = false) MultipartFile file, @RequestParam(value = "username", required = false) String username) {
        // 测试 multipart/form-data 类型 form-data里有多个参数
        if (file == null || file.isEmpty()) {
            System.out.println("文件参数为空");
        } else {
            System.out.println("文件参数不为空");
        }

        System.out.println("username:"+username);

        return "/ok";
    }

    @PostMapping(value = "/require")
    public String require(FormData formData) {
        // 测试 multipart/form-data 类型 form-data里有多个参数, 实体类接收
        // 发现 必须配置 StandardServletMultipartResolver 支持才可以正常解析
        // 发现就算是一个参数也没有，formData对象也不是null
        System.out.println("formData:" + formData);
        return "/ok";
    }

    @PostMapping(value = "/noRequire")
    public String noRequire(@RequestBody(required = false) FormData formData) {
        // @RequestBody 不能用在 multipart/form-data 类型上
        // Content-Type 'multipart/form-data;boundary=--------------------------559018150974839451876429;charset=UTF-8' is not supported
        System.out.println("formData:" + formData);
        return "/ok";
    }
}
