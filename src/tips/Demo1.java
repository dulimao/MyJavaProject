package tips;


import sun.misc.LRUCache;

import java.util.LinkedHashMap;

/**
*@author: 杜立茂
*@createDate  : 2019/3/23 20:55
*@description: 在散列表中使用对象，必须重写对象的equals()和hashCode();
*/

public class Demo1 {

    public static void main(String[] args){
        Person person1 = new Person("axin",22);
        Person person2 = new Person("axin",22);
        Person person3 = new Person("ating",21);
        System.out.println("person1 == person2 :" + (person1 == person2));
        System.out.println("person1.equals(person2): " + person1.equals(person2));
        System.out.println("person1.hasncode: " + person1.hashCode());
        System.out.println("person2.hashcode: " + person2.hashCode());


        //没有重写hashCode方法：
//    person1 == person2 :false
//    person1.equals(person2): true
//    person1.hasncode: 356573597
//    person2.hashcode: 1735600054
        //tips:两个对象equals相同，hashcode不一定相同
        //      两个对象相等，hashcode一定相同
        //      两个对象hashcode相同，他们不一定相等（hash冲突）


        //重写hashcode：
//        person1 == person2 :false
//        person1.equals(person2): true
//        person1.hasncode: 2023306
//        person2.hashcode: 2023306

    }





}

class Person {
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[name: " +name + " age: " + age + "]" ;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null)
            return false;

        //如果是同一个对象则返回true
        if (this == obj) {
            return true;
        }

        //判断类类型是否相同
        if (this.getClass() != obj.getClass()){
            return false;
        }

        Person person = (Person) obj;
        return this.name.equals(person.name) && this.age == person.age;

    }

    @Override
    public int hashCode() {
        int nameHashCode = name.toUpperCase().hashCode();
        return nameHashCode ^ age;
    }
}
