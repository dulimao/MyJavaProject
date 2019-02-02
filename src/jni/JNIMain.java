package jni;


import java.util.Random;


public class JNIMain {


    public String key = "java";

    static {
        System.loadLibrary("Project2");
//        initIDS();
    }



    public native String accessField();

    public native static String getStringFromC();


    public native static int[] sortArray(int[] arr);


    public native static void cache();

    public native static void initIDS();

    public native static void diff(String path,String format,int fileNum);

    public static void main(String[] args){

//        System.out.println(getStringFromC());

        //JNIMain jniMain = new JNIMain();

//        System.out.println(jniMain.accessField());
//        System.out.println("key: " + jniMain.key);
//        UUID.randomUUID().toString();

//        jniMain.accessField();

//        int[] arr = {6, 1, 3, 9, 2};
//        int[] arrs = sortArray(arr);
//        for(int i = 0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }
//        for(int i = 0;i<arrs.length;i++){
//            System.out.println(arrs[i]);
//        }

//        for (int i = 0; i < 10; i++){
//            cache();
//
//        }

        String path = "C:\\Users\\Administrator\\Desktop\\timg.jpg";
        String format = "C:\\Users\\Administrator\\Desktop\\timg%d.jpg";
        diff(path,format,3);
        System.out.println("拆分完成了");
    }

    public int accessMethod(int max){
        System.out.println("执行了");
        return new Random().nextInt(max);
    }
}
