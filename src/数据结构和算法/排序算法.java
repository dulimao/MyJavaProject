package 数据结构和算法;

/**
*@author: 杜立茂
*@createDate  : 2018/12/26 11:19
*@description:
 *              1、插入排序：
 *                 直接插入排序：
 *                 二分法插入排序：
*/

public class 排序算法 {

    public static void main(String[] args){
        int [] arr = new int[]{5,2,7,1,9,3};
//        int[] newArr = selectSort(arr);
//        printArr(newArr);
//
        int [] newArr1 = mallSort(arr);
        printArr(newArr1);

//        int[] newArr2 = insertSort(arr);
//        printArr(newArr2);

    }


    /**
     * 1、选择排序 时间复杂度：O(n平方)
     * @param a
     * @return
     */
    private static int[] selectSort(int a[]){
        for (int i = 0; i < a.length - 1; i++){//轮数
            for (int j = i; j < a.length; j++){//第i个元素和他后面的元素比较，大的放后面
                if (a[i] > a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    /**
     * 2、冒泡排序 时间复杂度：O(n平方)
     * @param a
     * @return
     */
    private static int[] mallSort(int a[]){
        for (int i = 0; i < a.length - 1; i++){//轮数
            for (int j = 0; j < a.length - 1 - i; j++){//相邻的两个元素比较，大的放后面
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    /**
     * 3、直接插入排序  时间复杂度O(n)
     *    ---[5 2 7 1 9 3]
     * 1: ---2 5 [7 1 9 3]
     * 2: ---2 5 7 [1 9 3]
     * 3: ---1 2 5 7 [9 3]
     * 4: ---1 2 5 7 9 [3]
     * 5: ---1 2 3 5 7 9
     *
     * @param a
     * @return
     */
    private static int[] insertSort(int[] a){
        for (int i = 1; i < a.length; i++){
            for (int j = i - 1; j >= 0; j--){
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }else{
                    break;
                }
            }
        }
        return a;
    }




    private static void printArr(int[] arr){
        System.out.println();
        for (int i = 0; i < arr.length; i++){
            System.out.print(" - " + arr[i]);
        }
    }
}
