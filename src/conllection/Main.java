package conllection;

import java.util.*;

/**
*@Author: 杜立茂
*@CreateDate  : 2018/12/20 10:42
*@Description: 数组：一串连续的内存空间
 *             集合：是存储对象数据的容器。
 *             比数组的优势：集合可以存储任意类型的数据，
 *                          集合可以动态改变长度。
 * ------------单列集合：
 *             Collection:是单列集合的跟接口（基础规范）
 *                  子接口：List,Set
 *                  List:有序（添加和取出的顺序，不是指排序），可重复，list接口特有方法的操作都和索引值有关
 *                  Set:无序，不可重复
 *                  equals:比较内存地址，==比较内容
 *             java基础规范：重写equals()方法，一般需要重写hashcode()方法
 *             Iterator（迭代器）作用：
 *                              原理：看源码
 *                              注意：迭代过程中不允许集合对象修改集合的个数
 *
 *             ArrayList:
 *                      原理：底层维护了一个Object类型的数组，初始容量为10，扩容倍数：0.5倍，
 *                       特点：查询快，增删慢,因为数组内存地址是连续的，查询直接定位索引，增删会有数组的copy操作
 *             LinkedList:
 *                      原理：底层用链表实现，数据存储方式为  元素1 + （元素2）下个元素的内存地址-----元素2 + 下个元素的内存地址
 *                      特点：查询满，增删快，
 *                      因为内存地址不连续，查询需要从头开始一个一个的找，删除直接修改内存地址的值就可以
 *                      栈（先进后出） push() pop()
 *                      队列（先进先出） offer() poll()
 *             Vector:底层也是Object数组，并且是线程安全的
 *
 *             Set:
 *             HashSet:基于哈希表(桶式结构，一个位置可以存储多个数据即hash值计算的位置相同，但是equals方法返回false)，
 *                     底层是HashMap,无序，不可重复，需要重写hashcode()和equals()方法
 *                     存取速度快
 *             TreeSet:如果元素具备自然排序特新，就会按照元素的自然顺序进行排序存储
 *                     底层：红黑树（二叉树）做小右大,当三个元素没有构成二叉树结构，则会自动调整跟节点，以构成二叉树
 * ------------双列集合： Map:双列集合的跟接口
 *                       特点：以键值对存储，键不能重复，值可以重复,无序
 *                       HashMap:数组 + 链表  初始容量16，负载因子0.75，1.8后，当链表长度大于8，链表会转换成红黑树
 *                       TreeMap:红黑树（二叉树），
 *                           特点：会对元素的键进行排序
 *                           注意：如果键具备自然顺序，则会对键进行排序
 *                                 如果不具备自然顺序，那么键所属的类必须实现Comparable接口，并实现比较规则
 *                                 如果不具备自然顺序，也没有实现接口，那么需要在treemap构造器中传入比较器
 *                       HashTable:实现方式与hashmap一行，线程安全，但是效率低
 *             集合工具类：Collections
*/

public class Main {

    public static void main(String[] args){

//        LinkedList list = new LinkedList();
//        list.add("aaa");
//        list.add("bbb");
//        list.add("ccc");
//        list.add(1,"dd");
//        list.listIterator();
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        Map<String,String> map = new HashMap<>();
        map.put("杜立茂","党玉婷");
        map.put("党玉婷","杜立茂");
//        for (Map.Entry<String,String> entry : map.entrySet()){
//            System.out.println("键：" + entry.getKey());
//            System.out.println("值：" + entry.getValue());
//        }

//        Set<Map.Entry<String, String>> entries = map.entrySet();
//        Iterator iterator = entries.iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String,String> entry = (Map.Entry<String, String>) iterator.next();
//            System.out.println(entry.getKey());
//        }

//        Iterator iterator = map.keySet().iterator();
//        while (iterator.hasNext()){
//            String key = (String) iterator.next();
//            String value = map.get(key);
//            System.out.println("键：" + key + " value: " + value);
//        }

//        Collection collection = map.values();

        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        treeMap.put('b',2);
        treeMap.put('d',4);
        treeMap.put('h',12);
        treeMap.put('a',1);
        System.out.println(treeMap);

        int [] a = {2,1,7,4,3};
        //快速选择排序
//        for (int i = 0;i < a.length - 1;i++){
//            for (int j = i + 1;j < a.length; j++){
//                if (a[i] > a[j]){
//                    int temp = a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//
//                }
//            }
//        }

        //冒泡排序
        for (int i = 0;i < a.length - 1;i++){
            for (int j = 0;j < a.length - i - 1;j++){
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        for (int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
