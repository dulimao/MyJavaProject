package tips.algorithm_demo;

/**
*@author: 杜立茂
*@createDate  : 2019/4/6 23:06
*@description: 泛型类
*/

public class Demo2<T> {

    public static void main(String[] args){
        Demo2<String> demo = new Demo2<>();
        demo.write("hello");
        System.out.println(demo.read());
    }


    private T value;

    public void write(T v) {
        value = v;
    }

    public T read() {
        return value;
    }

}

/**
 * 泛型接口
 * @param <T>
 */
interface Comparable<T>{
    public int compareTo(T other);
}
