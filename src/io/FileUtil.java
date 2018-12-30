package io;

import java.io.File;

public class FileUtil {

    /**
     * 递归遍历文件夹
     * @param file
     */
    public static void listFile(File file){
        if (!file.exists()){
            throw new IllegalArgumentException(file + " 文件不存在");
        }
        if (!file.isDirectory()){
            throw new   IllegalArgumentException(file + " 没有子目录");
        }

        File[] files = file.listFiles();
        if (files != null && files.length > 0){
            for (File f : files){
                if (f.isDirectory()){
                    listFile(f);
                }else {
                    System.out.println(f);
                }
            }
        }
    }
}
