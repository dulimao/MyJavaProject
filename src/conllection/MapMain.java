package conllection;

import java.util.*;

public class MapMain {

    public static void main(String[] args){
//        HashMap<Person,String> map = new HashMap<>();
//        map.put(new Person(110,"狗娃"),"单生狗");
//        map.put(new Person(111,"狗剩"),"狗不理");
//        map.put(new Person(110,"狗娃"),"狗子");//会覆盖第一个元素
//        for (Map.Entry<Person,String> entry : map.entrySet()){
//            System.out.println(entry.getKey() + "" + entry.getValue());
//        }

//        TreeMap<Person,String> treeMap = new TreeMap<>();
//        MyComparator comparator = new MyComparator();
//        TreeMap<Person,String> treeMap = new TreeMap<>(comparator);
//        treeMap.put(new Person(111,"狗娃"),"单生狗");
//        treeMap.put(new Person(110,"狗剩"),"狗不理");
//        treeMap.put(new Person(112,"狗蛋"),"狗蛋子");
//        System.out.println(treeMap);

        String str1 = "hello";
        String str2 = new String("hello");
        str2 = str2.intern();
        String str3 = str2;
        System.out.println("str1 == str2:" + (str1 ==str2));
        System.out.println("str1 == str3:" + (str1 ==str3));
        System.out.println("str2 == str3:" + (str2 ==str3));
        System.out.println("str1 equals str2:" + (str1.equals(str2)));
        System.out.println("str1 equals str3:" + (str1.equals(str3)));
        System.out.println("str2 equals str3:" + (str2.equals(str3)));

        HashMap<String,String> map = new HashMap<>();
        map.put(null,null);
        Hashtable<String,String> table = new Hashtable<>();
        table.put("","");

    }
}

class Person  {//implements Comparable<Person>
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[" + name + "," + id + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return this.id == person.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
//
//    @Override
//    public int compareTo(Person o) {
//        return this.id - o.id;
//    }
}

/**
 * 自定义比较器
 */
class MyComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.id - o2.id;
    }
}
