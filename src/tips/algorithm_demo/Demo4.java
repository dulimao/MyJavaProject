package tips.algorithm_demo;

public class Demo4 {


    public static void main(String[] args) {
        String[] arr = new String[]{"hello","wrold","java"};
        System.out.println(findMax(arr,new MyComparator()));
    }


    public static <T> T findMax(T[] arr,Comparator<? super T> cmp) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cmp.compare(arr[i],arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }


    static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String lhs, String rhs) {
            return lhs.compareToIgnoreCase(rhs);
        }
    }

    interface Comparator<T> {
        int compare(T lhs,T rhs);
    }
}


