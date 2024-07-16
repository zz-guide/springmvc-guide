package org.zz.springmvc.guide.restful.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.zz.springmvc.guide.restful.pojo.User;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/requestEntity")
public class RequestEntityController {

    @PostMapping("/test")
    public Map<String, Object> test(RequestEntity<User> request) {
        // RequestEntity 对象里包含了详细的请求信息，包括请求行，请求头，请求体信息
        // 获取请求方法
        HttpMethod method = request.getMethod();
        System.out.println("method:"+method);
        // 获取请求url
        URI url = request.getUrl();
        System.out.println("url:"+url);
        // 获取请求头
        HttpHeaders headers = request.getHeaders();
        System.out.println("headers:"+headers);

        // 获取请求头中的内容类型
        MediaType contentType = headers.getContentType();
        System.out.println("contentType:"+contentType);

        User body = request.getBody();
        System.out.println("body:"+body);

        Map<String , Object> map = new HashMap<>();
        map.put("msg", "success");
        return map;
    }
}
