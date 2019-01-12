package 数据结构和算法;

public class 字符串 {

    public static void main(String[] args){
        System.out.println(reverse("abcdefg"));
        System.out.println(translateString("abcdefg"));

    }


    /**
     * 反转字符串
     * @param str
     * @return
     */
    public static String reverse(String str){
        if (str == null || str.equals("")){
            return str;
        }
        return str.charAt(str.length() - 1) + reverse(str.substring(0,str.length() - 1));
    }

    /**
     * 向左平移某段字符串
     * @param str
     * @return
     */
    public static String translateString(String str){

        int n = (str.length() - 1) / 2;//左移n位
        String str1 = reverse(str.substring(0,n + 1));
        String str2 = reverse(str.substring(n + 1));
        System.out.println(str1);
        System.out.println(str2);
        return reverse(str1 + str2);
    }

    /**
     * 寻找最大子串
     * @param str
     * @return
     */
    public static String queryMaxStr(String str){
        return "";
    }


    /**
     * 找出第一个不重复的字符
     * @param str
     * @return
     */
    public static String queryFirstStr(String str){
        return "";
    }



}
