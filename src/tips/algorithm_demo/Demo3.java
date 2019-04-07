package tips.algorithm_demo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
*@author: 杜立茂
*@createDate  : 2019/4/7 13:19
*@description: 限制通配符,泛型及泛型集合不是协变的，数组是协变的
 *              泛型方法
*/

public class Demo3 {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {new Circle(2),new Square(1)};
        Square[] squares = new Square[]{new Square(2)};
        totalArea(shapes);
        totalArea(squares);

        List<Shape> list = new ArrayList<>();
        list.add(new Circle(1));
        list.add(new Square(2));
        totalArea(list);

        List<Square> squarelist = new ArrayList<>();
        squarelist.add(new Square(1));
        squarelist.add(new Square(2));
        totalArea(squarelist);

        System.out.println(contains(squares,new Circle(1)));

        Shape shape = findMax(shapes);
        System.out.println(shape.toString());

        List<String> stringList = new ArrayList<>();
        stringList.add("hello world");
        Object obj = stringList;
        ArrayList<String> strings = (ArrayList<String>) obj;
        System.out.println(strings.get(0));


        ArrayList<String>[]  arr1 = new ArrayList[10];
        ArrayList<Double> doubleList = new ArrayList<>();
        doubleList.add(2.2);
        Object[] arr2 = arr1;
        arr2[0] = doubleList;
        String s = arr1[0].get(0);//ClassCastException
        System.out.println(s);




    }

    public static void totalArea(Shape[] arr) {
        int total = 0;
        for (Shape shape : arr) {
            total += shape.getArea();
        }
        System.out.println("总面积： " + total);
    }

    public static void totalArea(Collection<? extends Shape> arr) {
        int total = 0;
        for (Shape shape : arr) {
            total += shape.getArea();
        }
        System.out.println("面积：" + total);
    }

    public static <T> boolean contains(T[] arr,T x){
        if (x instanceof Shape) {
            for (T value : arr) {
                if (x.equals(value)) {
                    return true;
                }
            }
        }else {
            throw new ClassCastException("类型转换错误");
        }
        return false;
    }

    public static <T extends Comparable<? super T>> T findMax(T[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                 //maxIndex = i;
            }
        }
        return arr[maxIndex];
    }


}
