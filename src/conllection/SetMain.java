package conllection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {

    public static void main(String[] args){
//        Set sets = new HashSet();
//        sets.add("张三");
//        sets.add("李四");
//        sets.add("王五");
//        Iterator iterator = sets.iterator();
//        while (iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }

//        sets.add(new Studen(1,"狗娃"));
//        sets.add(new Studen(3,"狗剩"));
//        sets.add(new Studen(1,"狗娃"));
        Set sets = new TreeSet();
//        sets.add(2);
//        sets.add(1);
//        sets.add(6);
//        sets.add(4);

        sets.add(new Studen(1,"jj"));

        System.out.println(sets);
    }


}
class Studen{
    int stuId;
    String name;

    public Studen(int stuId, String name) {
        this.stuId = stuId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + stuId + " " + name + ")";
    }

    @Override
    public int hashCode() {
        return stuId;
    }

    @Override
    public boolean equals(Object obj) {
        Studen studen = (Studen) obj;
        return this.stuId == studen.stuId;
    }
}
