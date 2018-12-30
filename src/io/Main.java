package io;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        testEncode();
//        FileUtil.listFile(new File("F:\\wapper"));
//        RandomAccessFileTest.test(new File("RandomAccessFileTest.text"));
//        new 字节流().readFile(new File("RandomAccessFileTest.text"));
        long start = System.currentTimeMillis();
        new 字节流().copyFileByBuffer(new File("adb.exe"), new File("adb_copy1.exe"));
        System.out.println(System.currentTimeMillis() - start);
    }


    /**
     * 编码测试 编码和解码要用同一种方式，不然会乱码
     */
    private static void testEncode() throws UnsupportedEncodingException {

        String str = "杜立茂ABC";
        //utf-8编码 中文占三个字节 英文占一个字节
        byte[] buff = str.getBytes();
        for (byte b : buff) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
//        e6 9d 9c e7 ab 8b e8 8c 82 41 42 43

        System.out.println();

        byte[] buff1 = str.getBytes("gbk");
        for (byte b : buff1) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
//        b6 c5 c1 a2 c3 af 41 42 43
    }

}

