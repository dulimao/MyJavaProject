package io;

import java.io.*;

/**
*@Author: 杜立茂
*@CreateDate  : 2018/12/18 18:41
*@Description: 字符流：Reader:抽象类 操作的是字符文本文件
 *                     Writer:抽象类
 *                     InputstreamReader:完成char流解析为byte流，按照编码解析
 *                     OutputStreamWriter:提供byte流到char流，按照编码处理
 *                     FileReader:
 *                     FileWriter:
 *                     BufferedReader:过滤器 可以readline()
 *                     BufferedWriter/PrintWriter:
*/

public class 字符流 {

    public static void main(String[] args){
        print2();
    }

    public static void print(){
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(
                    new FileInputStream(new File("src\\info.txt"))
            );
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    new FileOutputStream("info.txt")
            );
            char[] chars = new char[1024];
            int len;
            while ((len = inputStreamReader.read(chars)) != -1){
                System.out.println(new String(chars,0,len));//自动识别换行
                outputStreamWriter.write(chars,0,len);
                outputStreamWriter.flush();
            }
            inputStreamReader.close();
            outputStreamWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void print1(){
        try {
            FileReader fileReader = new FileReader("info.txt");
            FileWriter fileWriter = new FileWriter("info1.txt",true);//追加
            char[] buff = new char[1024];
            int len;
            while ((len = fileReader.read(buff)) != -1){
                fileWriter.write(buff,0,len);
                fileWriter.flush();
            }
            if (fileReader != null){
                fileReader.close();
            }
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void print2(){
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("info.txt"))
            );
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream("info2.txt"))
            );

            PrintWriter printWriter = new PrintWriter("info3.txt");

            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                printWriter.println(line);
                printWriter.flush();
            }
            bufferedReader.close();
            bufferedWriter.close();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
