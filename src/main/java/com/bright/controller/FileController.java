package com.bright.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author wangliang
 * @date 2022/8/26 22:38
 */
@RestController
public class FileController {

    public static void main(String[] args) {
        try {
            long l = System.currentTimeMillis();
            System.out.println();
            // 获取文件
            FileChannel readChannel = FileChannel.open(Paths.get("C:\\software\\ideaIU-2020.1.exe"), StandardOpenOption.READ);
            MappedByteBuffer data = readChannel.map(FileChannel.MapMode.READ_ONLY, 0, readChannel.size());
            FileChannel writeChannel = FileChannel.open(Paths.get("C:\\software\\history\\ideaIU-2020.1.exe"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            //数据传输
            writeChannel.write(data);
            readChannel.close();
            writeChannel.close();
            long d = System.currentTimeMillis();
            System.out.println(d-l);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @PostMapping("/updateFile")
    public void uploadFile(MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response) {
        try {
            byte[] bytes = multipartFile.getBytes();
            InputStream inputStream = multipartFile.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
