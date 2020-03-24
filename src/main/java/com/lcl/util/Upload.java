package com.lcl.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @author lcl
 * @date 2019/11/1 23:31
 * @Description
 */
public class Upload {
    public static String makeFileName(String filename) {  //2.jpg
        //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return UUID.randomUUID().toString() + "_" + filename;
    }


    //    上传文件
    public static String saveImg(MultipartFile file, String username) {
        //文件名
        String fileName = makeFileName(file.getOriginalFilename());

        //获取图片存储路径
        String filePath = PathUtil.getImgUrl() + username + "\\";

        System.out.println("上传生活照：" + filePath);
        InputStream input = null;
        try {
            input = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //当文件夹不存在时，创建文件夹
        File file1 = PathUtil.creatFile(filePath, fileName);//设置图片存储路径

        OutputStream out = null;
        try {
            out = new FileOutputStream(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] bytes = new byte[1024];    //缓冲区
        int len = -1;
        try {
            while ((len = input.read(bytes)) != -1)
                out.write(bytes, 0, len);
            out.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
