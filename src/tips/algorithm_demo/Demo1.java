package tips.algorithm_demo;

public class Demo1 {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{new Circle(1),new Square(10)};
        System.out.println(findMax(shapes));
    }


    /**
     * 找出数组中最大的一个，数组元素类型为引用类型
     * @param arr
     * @return
     */
    public static Comparable findMax(Comparable[] arr){

        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }

        return arr[maxIndex];

    }


}


//JDK1.5 Compareable支持泛型编程
abstract class Shape implements Comparable<Shape> {
    abstract int getArea();
}

class Circle extends Shape {

    private int r;
    public Circle(int r) {
        this.r = r;
    }

    @Override
    int getArea() {
        return (int) (2 * Math.PI * r);
    }

    @Override
    public int compareTo(Shape o) {
       Shape shape = (Shape) o;
       if (this.getArea() > shape.getArea())
           return 1;
       else if (this.getArea() < shape.getArea())
           return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "圆形";
    }
}

class Square extends Shape{
    int w;
    public Square(int w) {
        this.w = w;
    }


    @Override
    int getArea() {
        return w * w;
    }

    @Override
    public int compareTo(Shape o) {
        Shape shape = (Shape) o;
        if (this.getArea() > ((Shape) o).getArea()) {
            return 1;
        } else if (this.getArea() < shape.getArea()) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "矩形";
    }
}
