package http;

/**
*@Author: 杜立茂
*@CreateDate  : 2018/12/18 14:54
*@Description: JAVA文件模型：在硬盘上文件是以字节流形式存储的
*/

public class Mian {

    public static void main(String[] args){
//        new HttpUrlConnectionThread().start();
        MultiThreadDowload multiThreadDowload = new MultiThreadDowload();
        multiThreadDowload.startDownload();

    }
}
