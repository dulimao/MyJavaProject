package 基础;


/**
*@author: 杜立茂
*@createDate  : 2018/12/29 9:54
*@description: 二进制中最高位是1则是负数，最高位是0则是证书，负数在计算机中存储的是补码
 *
 *              -7的存储过程：
 *              1、绝对值得二进制
 *                  00000111
 *              2、取反
 *                  11111000
 *              3、家1
 *                  11111001
*/

public class Main {
    public static void main(String[] args){
//        byte b = 10;
//        int a = b;

//        int a = 128;
//        byte b = (byte) a;//强制类型转换，取低八位，前面的数据就会丢掉不要
//        System.out.println(b);
//        System.out.println(Integer.toBinaryString(-7));

        byte b1 = 1;
        byte b2 = 2;
        byte b3 = (byte) (b1 + b2);//byte,short,char在运算的时候都会转换成Int类型再运算
        System.out.println(b3);
        int a = ~9;
        System.out.println(a);


    }
}
