package conllection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
        MyComparator comparator = new MyComparator();
        TreeMap<Person,String> treeMap = new TreeMap<>(comparator);
        treeMap.put(new Person(111,"狗娃"),"单生狗");
        treeMap.put(new Person(110,"狗剩"),"狗不理");
        treeMap.put(new Person(112,"狗蛋"),"狗蛋子");
        System.out.println(treeMap);

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
