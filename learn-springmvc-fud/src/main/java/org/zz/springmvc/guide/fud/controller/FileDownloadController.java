package org.zz.springmvc.guide.fud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.zz.springmvc.guide.fud.utils.FileUploadUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/file/download")
public class FileDownloadController {

    @GetMapping("/t1")
    public ResponseEntity<?> t1() throws IOException {
        Path downloadFilePath = Paths.get(FileUploadUtils.getJarPath(), FileUploadUtils.DOWNLOAD_PATH, "test.jpeg");
        File file = new File(downloadFilePath.toString());
        if (!file.exists()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // 文件下载设置
        HttpHeaders httpHeaders = new HttpHeaders();
        // 告知浏览器这是一个字节流，浏览器处理字节流的默认方式就是下载。
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 在常规的 HTTP 应答中，Content-Disposition 响应标头指示回复的内容该以何种形式展示，是以内联的形式（即网页或者页面的一部分），还是以附件的形式下载并保存到本地
        httpHeaders.setContentDispositionFormData("attachment", file.getName());

        // readAllBytes 读取
        byte[] imageBytes = Files.readAllBytes(downloadFilePath);

        // 将字节数组封装为Resource对象
        Resource resource = new ByteArrayResource(imageBytes);

        return new ResponseEntity<>(resource, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/t2")
    public ResponseEntity<?> t2() throws IOException {
        Path downloadFilePath = Path.of("https://i0.hdslb.com/bfs/archive/6e8e16d02a0f0c1cf0b246e13a5bf3eadef52d4e.jpg");
        String filename = downloadFilePath.getFileName().toString();

        // 文件下载设置
        HttpHeaders httpHeaders = new HttpHeaders();
        // 告知浏览器这是一个字节流，浏览器处理字节流的默认方式就是下载。
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 在常规的 HTTP 应答中，Content-Disposition 响应标头指示回复的内容该以何种形式展示，是以内联的形式（即网页或者页面的一部分），还是以附件的形式下载并保存到本地
        httpHeaders.setContentDispositionFormData("attachment", filename);

        // readAllBytes 读取
        byte[] imageBytes = Files.readAllBytes(downloadFilePath);

        // 将字节数组封装为Resource对象
        Resource resource = new ByteArrayResource(imageBytes);

        return new ResponseEntity<>(resource, httpHeaders, HttpStatus.OK);
    }
}
