package 数据结构和算法;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Stack;

/**
 * 合并两个单向有序链表
 */
public class 合并两个有序单链表 {

    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node12 = new Node(3);
        Node node13 = new Node(5);
        node1.next = node12;
        node12.next = node13;

        Node node2 = new Node(2);
        Node node22 = new Node(4);
        Node node23 = new Node(6);
        node2.next = node22;
        node22.next = node23;

//        Node node = merageTwoList(node1,node2);
//        while (node != null){
//            System.out.println("node: " + node.value );
//            node = node.next;
//        }

        revertNodeList(node1);

    }


    /**
     * 递归合并两个链表
     * @param node1
     * @param node2
     * @return
     */
    public static Node merageTwoList(Node node1,Node node2){
        if (node1 == null)
            return null;
        if (node2 == null){
            return null;
        }

        Node headNode = null;
        if (node1.value <= node2.value){
            headNode = node1;
            headNode.next = merageTwoList(node1.next,node2);
        }else {
            headNode = node2;
            headNode.next = merageTwoList(node1,node2.next);
        }
        return headNode;
    }

//    private static Node merageTwoList1(Node node1,Node node2){
//        if (node1 == null){
//            return null;
//        }
//        if (node2 == null){
//            return null;
//        }
//
//        Node newNode = node1;
//        while (newNode.next != null){
//            while (node2.next != null){
//                if (newNode.value > node2.next.value){
//
//                }
//            }
//
//        }
//    }


    /**
     * 反转链表
     * @param node
     */
    public static void revertNodeList(Node node){
        Stack<Node> nodes = new Stack<>();
        if(node != null){
            nodes.push(node);
        }

        while (node.next != null){
            nodes.push(node.next);
            node = node.next;
        }

        while (nodes.size() != 0 && nodes.peek() != null){
            System.out.print(nodes.pop().value + " - ");
        }
    }
}
class Node{
    int value;
    Node next;
    Node(int value){
        this.value = value;
    }
}
