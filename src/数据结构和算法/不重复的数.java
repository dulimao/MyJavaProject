package 数据结构和算法;


import java.util.Random;

/**
*@author: 杜立茂
*@createDate  : 2019/1/2 13:41
*@description: 从m个数中取n个数，切不重复
*/

public class 不重复的数 {


    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int[] result = new int[3];

        for (int i = 0; i < result.length; i++){
            int index = new Random().nextInt(arr.length - i);//arr.length - 1 是关键，下面几部调换位置
            result[i] = arr[index];
            System.out.println(index);
            //调换位置
            int temp = arr[index];
            arr[index] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        for (int i = 0; i < result.length; i++){
            System.out.println("随机数" + i + " : " + result[i]);
        }

    }

}
