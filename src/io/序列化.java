package io;

import java.io.*;

/**
*@Author: 杜立茂
*@CreateDate  : 2018/12/18 19:16
*@Description: 序列化：将object转化为byte序列，反之则是反序列化
 *                     ObjectOutputStream:序列化流
 *                     OjbectInputSteram:反序列化流
*/


enum Sex{
    man("男"),woman("女");
    String value;
    private Sex(String value){
        this.value = value;
    }

}
public class 序列化 {

    public static void main(String[] s){
//        serilizableObject();
        System.out.println(Sex.man.value);

    }

    /**
     * 序列化和反序列化对象
     */
    public static void serilizableObject(){
        try {
            //序列化对象
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("person.txt"));
            Person person = new Person();
            person.setName("杜立茂");
            person.setAge("28");
            outputStream.writeObject(person);
            outputStream.flush();
            outputStream.close();

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("person.txt"));
            Person person1 = (Person)inputStream.readObject();
            System.out.println(person1.getName() + "  " + person1.getAge());
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
