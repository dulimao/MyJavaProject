package 数据结构和算法;

public class 两个数交换位置 {

    public static void main(String[] args){
        //不出现第三方变量
        int a = 3;
        int b = 5;
        
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(" a : " + a + " b : " + b);

    }
}
