package io;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
    private String name;

    private transient String age;//不被默认JVM序列化，但是可以自己实现序列化

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
            s.defaultWriteObject();
            s.writeChars(age);//自己序列化
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
            s.defaultReadObject();
            s.readObject();
    }
}
