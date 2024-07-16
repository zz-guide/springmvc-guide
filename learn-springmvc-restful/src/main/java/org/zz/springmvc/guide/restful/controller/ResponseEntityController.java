package org.zz.springmvc.guide.restful.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.zz.springmvc.guide.restful.pojo.User;

@RestController
@RequestMapping("/responseEntity")
public class ResponseEntityController {

    @GetMapping("/{id}")
    public ResponseEntity<?> test(@PathVariable("id") String id) {
        // ResponseEntity 自定义响应协议，包括状态码等
        if (id.equals("1")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        User user = new User();
        user.setUsername("用户");
        user.setPassword("密码");
        return ResponseEntity.ok(user);
    }
}
