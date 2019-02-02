package jni.update_patch.server;
/**
*@author: 杜立茂
*@createDate  : 2019/2/2 16:22
*@description: //差分开源项目（BsDiff,依赖于bzip）
 * 问题：1、过时或不安全警告 2、去掉严格检查（Windows）
 * -D _CRT_SECURE_NO_WARNINGS -D _CRT_NONSTDC_NO_DEPRECATE
 *
 *
 *
1.差分
旧版本apk、新版本apk

BsDiff开源项目（依赖于Bzip2）

1.根据下载的bsdiff4.3-win32-src代码，生成dll动态库，用于得到差分包
1)用了不安全的函数
2)用了过时的函数
3)SDL检查

2.仔细阅读源代码，修改bsdiff.cpp原文件
3.根据C/C++代码，编写java层代码，然后生成头文件
4.编写JNI函数，供Java层调用（注意统一编码 UTF-8  无BOM）


2.合并
*/

public class BsDiff {

    static{
        System.loadLibrary("BsDiff");
    }

    public native static void diff(String oldfile,String newfile,String patchfile);

    public static void main(String[] args){
        String oldfile = "C:\\Users\\Administrator\\Desktop\\old.apk";
        String newfile = "C:\\Users\\Administrator\\Desktop\\new.apk";
        String patchfile = "C:\\Users\\Administrator\\Desktop\\patch_apk.patch";

        diff(oldfile,newfile,patchfile);


    }
}
