package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
*@Author: 杜立茂
*@CreateDate  : 2018/12/18 14:48
*@Description: 随机访问文件测试
*/

public class RandomAccessFileTest {


    public static void test(File file){

        try {
            RandomAccessFile accessFile = new RandomAccessFile(file,"rw");
            accessFile.write('a');//只写一个字节
            accessFile.writeBytes("hello,world");
            System.out.println(accessFile.getFilePointer());
            accessFile.seek(1);
            byte[] buff = new byte[(int)file.length()];
            accessFile.read(buff);
            System.out.println(new String(buff));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
