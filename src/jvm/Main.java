package jvm;

import org.w3c.dom.NodeList;

/**
*@author: 杜立茂
*@createDate  : 2018/12/21 17:32
*@description: JVM:
 *             每个方法创建的时候，jvm都会为该方法开辟一片内存空间
 *             内存空间是数据该方法的，方法中的形参也是属于该方法的局部变量(参考图jvm1.jpg)
*/

public class Main {
    public static void main(String[] args){
        String a = "hello";
        String b = new String("hello");
        System.out.println("a == b 吗 " + a == b);//==比较的是内存地址，a在常量池中，b在堆内存中，所以返回false
        System.out.println("a的hashcode:" + a.hashCode());
        System.out.println("b的hashcode:" + b.hashCode());//a和b的hashcode相同，应为String类已经重写了hashcode()方法
    }


    //如 link1: 1->3->5   link2: 2->4->6
    //合并 link3: 1->2->3->4->5->6
//    public NodeList merageLink(NodeLink link1,NodeLink link2){
//
//
//    }
}
class NodeLink{
    int val;
    NodeLink next;
    NodeLink(int val){
        this.val = val;
    }
}
