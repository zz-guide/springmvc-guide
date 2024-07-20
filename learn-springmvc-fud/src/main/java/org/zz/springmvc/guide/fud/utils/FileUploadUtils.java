package org.zz.springmvc.guide.fud.utils;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;

public class FileUploadUtils {
    public static final String UPLOAD_PATH = "/static/upload"; // 相对webapp的路径
    public static final String DOWNLOAD_PATH = "/static/download"; // 相对webapp的路径
    public static final String LOCAL_UPLOAD_PATH = "E:\\jungle\\github\\zz-guide\\springmvc-guide\\learn-springmvc-fud\\src\\main\\webapp\\static\\upload"; // 本机upload全路径

    public static String getClassesPath() {
        // ResourceUtils
        // 本质上是通过 classLoader 获取路径
        // classpath 其实就是 /WEB-INF/classes/
        String classPath = null;
        try {
            classPath = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("getClassesPath:" + classPath); // /target/learn-springmvc-fud-1.0-SNAPSHOT/WEB-INF/classes/
        return classPath;
    }

    public static String getClassesPath2() {
        // getResource("/") 本质上获取的也是 /WEB-INF/classes/, 可参考 ResourceUtils.getURL
        String classPath = Objects.requireNonNull(FileUploadUtils.class.getResource("/")).getPath();
        System.out.println("getClassesPath2:" + classPath); // /target/learn-springmvc-fud-1.0-SNAPSHOT/WEB-INF/classes/
        return classPath;
    }

    public static String getJarPath() {
        // 通过 File getParentFile() getParent() 获取 jar包 build 根路径
        String jarPath = new File(getClassesPath()).getParentFile().getParent();
        System.out.println("getJarPath:" + jarPath); // E:\jungle\github\zz-guide\springmvc-guide\learn-springmvc-fud\target\learn-springmvc-fud-1.0-SNAPSHOT
        return jarPath;
    }

    public static String getJarPath2() {
        String jarPath = new File(getClassesPath2()).getParentFile().getParent();
        System.out.println("getJarPath2:" + jarPath); // E:\jungle\github\zz-guide\springmvc-guide\learn-springmvc-fud\target\learn-springmvc-fud-1.0-SNAPSHOT
        return jarPath;
    }

    public static String getJarPath3(HttpServletRequest req) {
        ServletContext servletContext = req.getServletContext();
        String jarPath = servletContext.getRealPath(""); // 这里不能填null,应该填空字符串
        System.out.println("getJarPath3:" + jarPath);
        return jarPath;
    }

    public static String getUploadDirPath() {
        String uploadDirPath = Paths.get(getJarPath(), UPLOAD_PATH).normalize().toString();
        System.out.println("getUploadDirPath:" + uploadDirPath);
        return uploadDirPath;
    }

    public static String getUploadDirPath2() {
        String uploadDirPath = Paths.get(getJarPath2(), UPLOAD_PATH).normalize().toString();
        System.out.println("getUploadDirPath2:" + uploadDirPath);
        return uploadDirPath;
    }

    public static String getUploadDirPath3(HttpServletRequest req) {
        String uploadDirPath = Paths.get(getJarPath3(req), UPLOAD_PATH).normalize().toString();
        System.out.println("getUploadDirPath3:" + uploadDirPath);
        return uploadDirPath;
    }

    public static String getUserDirProperty() {
        String property = System.getProperty("user.dir");
        System.out.println("user.dir:" + property); // E:\tools\apache-tomcat-10.1.25\bin
        return property;
    }

    public static String getFilenameExtension(String originalFilename) {
        String filenameExtension = StringUtils.getFilenameExtension(originalFilename);
        System.out.println("getFilenameExtension，扩展名:" + filenameExtension);
        return filenameExtension;
    }

    public static String getFilenameExtension2(String originalFilename) {
        String filenameExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        System.out.println("getFilenameExtension2:" + filenameExtension);
        return filenameExtension;
    }

    public static void copy(String source, String newFilename) throws IOException {
        Files.copy(Paths.get(source), Paths.get(FileUploadUtils.LOCAL_UPLOAD_PATH, newFilename), StandardCopyOption.REPLACE_EXISTING);
    }

    public static String getDownloadDirPath() {
        String uploadDirPath = Paths.get(getJarPath(), DOWNLOAD_PATH).normalize().toString();
        System.out.println("getDownloadDirPath:" + uploadDirPath);
        return uploadDirPath;
    }
}
