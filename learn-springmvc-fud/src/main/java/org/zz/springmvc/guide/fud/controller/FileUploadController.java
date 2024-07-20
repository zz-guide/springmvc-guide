package org.zz.springmvc.guide.fud.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zz.springmvc.guide.fud.utils.FileUploadUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * spring6 配置，web.xml 增加  <multipart-config>
 * spring5 配置，commons-fileupload jar包 + CommonsMultipartResolver
 * <p>
 * 对于 springmvc来讲，静态资源如果想直接访问需要放置到webapp某个目录下，可以自定义
 * 如果请求的是静态资源，会交给DefaultServlet处理
 */

@Controller
@RequestMapping("/file/upload")
public class FileUploadController {


    @PostMapping("/t1")
    public String t1(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest req) throws Exception {
        if (multipartFile.isEmpty()) {
            System.out.println("文件不能为空");
            throw new Exception("文件不能为空");
        }

        String name = multipartFile.getName();
        System.out.println("form 表单 文件 input name属性:" + name);

        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println("原文件名称:" + originalFilename);

        FileUploadUtils.getFilenameExtension(originalFilename);
        System.out.println("========================================");
        assert originalFilename != null;
        FileUploadUtils.getFilenameExtension2(originalFilename);
        System.out.println("========================================");
        FileUploadUtils.getClassesPath();
        System.out.println("========================================");
        FileUploadUtils.getClassesPath2();
        System.out.println("========================================");
        FileUploadUtils.getJarPath();
        System.out.println("========================================");
        FileUploadUtils.getJarPath2();
        System.out.println("========================================");
        FileUploadUtils.getJarPath3(req);
        System.out.println("========================================");
        FileUploadUtils.getUploadDirPath();
        System.out.println("========================================");
        FileUploadUtils.getUploadDirPath2();
        System.out.println("========================================");
        FileUploadUtils.getUploadDirPath3(req);
        System.out.println("========================================");
        FileUploadUtils.getUserDirProperty();
        System.out.println("========================================");

        // 准备把文件读取到上传目录，文件名必须进行重命名
        String newFilename = String.format("%s.%s", UUID.randomUUID(), FileUploadUtils.getFilenameExtension(originalFilename));
        System.out.println("新文件名:"+newFilename);
        return "/ok";
    }

    @PostMapping("/t2")
    public String t2(@RequestParam("file2") MultipartFile multipartFile, HttpServletRequest req) throws Exception {
        if (multipartFile.isEmpty()) {
            throw new Exception("文件不能为空");
        }

        // 获取文件扩展名，比如：.jpg
        String filenameExtension = FileUploadUtils.getFilenameExtension(multipartFile.getOriginalFilename());

        // 判断服务器上传路径是否存在，不存在就创建
        String serverUploadDir = FileUploadUtils.getUploadDirPath3(req);
        File serverUploadDirFile = new File(serverUploadDir);
        if (!serverUploadDirFile.exists()) {
            serverUploadDirFile.mkdirs();
        }

        // 使用 multipartFile 打开一个输入流准备读取
        BufferedInputStream bis = new BufferedInputStream(multipartFile.getInputStream());

        // 文件名必须进行重命名
        String newFilename = String.format("%s.%s", UUID.randomUUID(), filenameExtension);
        String serverUploadFilePath = Paths.get(serverUploadDir, newFilename).toString();
        // 准备一个输出流写入
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(serverUploadFilePath));

        byte[] bytes = new byte[1024 * 100]; // 每次写100kb
        int readCount = 0;
        while ((readCount = bis.read(bytes)) != -1) {
            System.out.println("readCount:" + readCount);
            bos.write(bytes, 0, readCount);
        }

        bos.flush();
        bos.close();
        bis.close();

        // 最后保存到本机目录
        FileUploadUtils.copy(serverUploadFilePath, newFilename);

        System.out.println("图片保存成功");
        return "/ok";
    }

    @PostMapping("/t3")
    public String t3(@RequestParam("file3") MultipartFile multipartFile) throws Exception {
        if (multipartFile.isEmpty()) {
            throw new Exception("文件不能为空");
        }
        // 获取文件扩展名，比如：.jpg
        String filenameExtension = FileUploadUtils.getFilenameExtension(multipartFile.getOriginalFilename());

        // 判断服务器上传路径是否存在，不存在就创建
        String serverUploadDir = FileUploadUtils.getUploadDirPath();
        File serverUploadDirFile = new File(serverUploadDir);
        if (!serverUploadDirFile.exists()) {
            serverUploadDirFile.mkdirs();
        }

        // 文件名必须进行重命名
        String newFilename = String.format("%s.%s", UUID.randomUUID(), filenameExtension);
        Path serverUploadPath = Paths.get(serverUploadDir, newFilename);

        // 4. 使用transferTo()进行保存
        multipartFile.transferTo(serverUploadPath);

        // 最后保存到本机目录
        FileUploadUtils.copy(serverUploadPath.toString(), newFilename);

        System.out.println("图片保存成功");
        return "/ok";
    }
}
