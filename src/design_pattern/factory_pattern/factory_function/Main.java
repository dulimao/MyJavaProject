package design_pattern.factory_pattern.factory_function;


import design_pattern.factory_pattern.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

//工厂模式：工厂方法模式，抽象工厂模式
//意图：定义一个接口来创建对象，但是让子类决定哪些类需要被实例化，工厂方法把实例化的工作推迟到了子类去实现
public class Main {

    //工厂方法模式
    public static void main(String[] args){
//        HairInterface left = new LeftHair();
//        left.draw();

        HairFactory factory = new HairFactory();
//        HairInterface rightHair = factory.getHair(RightHair.class.getName());
//        rightHair.draw();

        HairInterface hairInterface = factory.getHairByKey("in");
        hairInterface.draw();

        Person person = (Person) getInstance();
        System.out.println(person);

    }

    /**
     * 根据配置文件生成任意对象
     * @return
     */
    public static Object getInstance(){
        try {
            FileReader reader = new FileReader("info.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String className = bufferedReader.readLine();
            Class clazz = Class.forName(className);
            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Object o = constructor.newInstance(null);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                String [] data = line.split("=");
                Field field = clazz.getDeclaredField(data[0]);
                field.setAccessible(true);
                if (field.getType() == int.class){
                    field.set(o,Integer.parseInt(data[1]));
                }else if (field.getType() == String.class){
                    field.set(o,data[1]);
                }
            }
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
