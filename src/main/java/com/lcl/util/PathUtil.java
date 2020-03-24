package com.lcl.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author lcl
 * @date 2019/11/2 12:53
 * @Description
 */
public class PathUtil {
    //创建文件夹
    public static File creatFile(String filepath, String filename) {
        File file = new File(filepath, filename);
        if (file.exists()) {
            System.out.println(file.getAbsolutePath()+","+file.length());
        }else{
            file.getParentFile().mkdirs();  //创建实际文件所在的文件夹
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static String getVUrl(){
        String filepath = "/user/userImg/";

        return filepath;
    }


    //        获取文件绝对路径
    public static String getImgUrl(){//获取文件夹userResource/userImg的实际路径
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }//File.separator 就是斜线，方便在不同情况下的转换
        String filePath=path.getParentFile().getParent()+File.separator+"src"+File.separator+"main"
                +File.separator+"resources"+File.separator+"static" +File.separator+"user"+File.separator
                +"userImg"+File.separator;
        return filePath;
    }

    public static boolean filerename(File file, String path) {
//        //想命名的原文件的路径
//        File file = new File("f:/a/a.xlsx");
//        //将原文件更改为f:\a\b.xlsx，其中路径是必要的。注意
//        file.renameTo(new File("f:/a/b.xlsx"));

        //将原文件夹更改为A，其中路径是必要的。注意
      return file.renameTo(new File(path));
    }

    public static void main(String[] args){
//        String fileName = "b.txt";
//        String filepath=  File.separator+"user"+File.separator+"userImg"+File.separator+"zs"+File.separator;
//
//        PathUtil.creatFile(filepath,fileName);
//        System.out.println(filepath);



        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
           String filePath=path.getParentFile().getParentFile().getParent()+File.separator+"uploads"+File.separator;
           String filePath5=path.getParentFile().getParentFile().getParent()+File.separator+"aaa"+File.separator;

            String filePath2=path.getParentFile().getParent()+File.separator+"src"+File.separator+"main"
                    +File.separator+"resources"+File.separator+"static" +File.separator+"user"+File.separator
                    +"userImg"+File.separator+"zs"+File.separator;


            System.out.println(path);
           System.out.println("=="+filePath);

          //实际文件路径 filepath+filename
            String fileName = "b.txt";
            String filepath=PathUtil.getImgUrl()+"zs"+File.separator;
            PathUtil.creatFile(filePath,fileName);

            filerename(new File(filePath),filePath5);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }

}
