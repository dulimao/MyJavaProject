package io;

import java.io.*;

/**
*@Author: 杜立茂
*@CreateDate  : 2018/12/18 15:01
*@Description: 字节流：Inputstrem:抽象了读取数据的方式
 *                     Outputstream:抽象了写入数据的方式
 *                     Dataoutputstream:对流的扩展功能，可以更加方便的读取int,long,字符等类型数据，多用于操作类型数据
 *             字节缓冲流：BufferedInputStream:对FileInputStream的包装
 *                        BufferedOutputStream:对FileOutputStream的包装 ---- 装饰者模式
*/

public class 字节流 {



    /**
     * 复制一个文件 速度最快 3M：几毫秒
     * @param srcFile
     * @param destFile
     */
    public void copyFile(File srcFile,File destFile){

        try {
            if (!srcFile.exists()){
                throw new IllegalArgumentException(srcFile + " 文件不存在");
            }
            if (!srcFile.isFile()){
                throw new IllegalArgumentException(srcFile + " 不是一个文件");
            }
            FileInputStream fileInputStream = new FileInputStream(srcFile);
            //如果目标文件不存在，则会自动创建
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);//append: 追加内容

            byte[] buf = new byte[1024 *2];
            int len;
            while ((len = fileInputStream.read(buf)) != -1){
                fileOutputStream.write(buf,0,len);
                fileOutputStream.flush();
            }

            fileInputStream.close();
            fileOutputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 利用带缓冲的字节流拷贝文件 3M：2万毫秒
     * @param srcFile
     * @param destFile
     */
    public void copyFileByBuffer(File srcFile,File destFile){
        try {
            if (!srcFile.exists()) {
                throw new IllegalArgumentException(srcFile + " 文件不存在");
            }
            if (!srcFile.isFile()) {
                throw new IllegalArgumentException(srcFile + " 不是一个文件");
            }

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFile));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFile));

            int len;
            while ((len = bufferedInputStream.read()) != -1){
                bufferedOutputStream.write(len);
                bufferedOutputStream.flush();
            }

            bufferedInputStream.close();
            bufferedOutputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
