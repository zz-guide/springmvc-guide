package org.zz.springmvc.guide.restful.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.UUID;


@Controller
@RequestMapping("/file")
public class FileController {

    @GetMapping("/uploadIndex")
    public String index() {
        return "/file_upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest req) throws IOException {
        // spring6 配置，web.xml 增加  <multipart-config>
        // spring5 配置，commons-fileupload jar包 + CommonsMultipartResolver

        String name = multipartFile.getName();
        System.out.println("表单里的文件属性的key值:"+name);
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println("原文件名称originalFilename:"+originalFilename);

        // spring的StringUtils提供了一个方法用来获取文件名的后缀
        String filenameExtension = StringUtils.getFilenameExtension(originalFilename);
        System.out.println("filenameExtension:"+filenameExtension);
        InputStream inputStream = multipartFile.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);

        ServletContext servletContext = req.getServletContext();
        // 判断上传目录存在不存在
        String realPath = servletContext.getRealPath("/upload");
        System.out.println("realPath:"+realPath);
        // 这个地方还是有必要判断一下目录存不存在的
        File file = new File(realPath);
        if (!file.exists()) {
           file.mkdirs();
        }

        // 准备把文件读取到上传目录，文件名必须进行重命名
        UUID uuid = UUID.randomUUID();
        File destFile = new File(file.getAbsolutePath() + "/" + uuid+"."+filenameExtension);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] bytes = new byte[1024 * 10]; // 每次10kb
        int readCount = 0;
        while ((readCount = bis.read(bytes)) != -1) {
            System.out.println("readCount:"+readCount);
            bos.write(bytes, 0, readCount);
        }

        bos.flush();
        bos.close();
        bis.close();

        return "/ok";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/upload/"+"1.jpg");
        System.out.println("realPath:"+realPath);
        File file = new File(realPath);
        if (file.exists()) {
            // 文件下载设置
            HttpHeaders httpHeaders = new HttpHeaders();
            // 告知浏览器这是一个字节流，浏览器处理字节流的默认方式就是下载。
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            // 在常规的 HTTP 应答中，Content-Disposition 响应标头指示回复的内容该以何种形式展示，是以内联的形式（即网页或者页面的一部分），还是以附件的形式下载并保存到本地
            httpHeaders.setContentDispositionFormData("attachment", file.getName());

            // readAllBytes 适合读取小内存的数据
            return new ResponseEntity<>(Files.readAllBytes(file.toPath()), httpHeaders, HttpStatus.OK);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
