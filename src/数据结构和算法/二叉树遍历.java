package 数据结构和算法;


import java.util.Stack;

/**
*@author: 杜立茂
*@createDate  : 2018/12/25 17:15
*@description: 二叉树
 *              二叉树遍历方式：
 *                   前序遍历：根-左-右
 *                   中序遍历：左-根-右
 *                   后序遍历：左-右-根
 *
 *
*/

public class 二叉树遍历 {

    static TreeNode<String> rootNode;

    public 二叉树遍历(){
        rootNode = new TreeNode<>(1,"A");
        createBinaryTree(rootNode);
    }

    public static void main(String[] args){
        二叉树遍历 binaryTree = new 二叉树遍历();
        int treeHeight = binaryTree.getTreeHeight();
        System.out.println("二叉树的高度：" + treeHeight);

        int treeSize = binaryTree.getTreeSize();
        System.out.println("二叉树的节点数：" + treeSize);


        System.out.println("前序遍历：");
        binaryTree.preOrder(rootNode);
        System.out.println();

        System.out.println("中序遍历：");
        binaryTree.midOrder(rootNode);
        System.out.println();

        System.out.println("后序遍历：");
        binaryTree.laterOrder(rootNode);

        System.out.println();
        System.out.println("栈结构-前序遍历");
        binaryTree.preOrderByStack(rootNode);
    }


    /**
     * 求树的深度
     * @return
     */
    public int getTreeHeight(){
        return getTreeHeight(rootNode);
    }

    /**
     * 递归方式
     * @param node
     * @return
     */
    private int getTreeHeight(TreeNode node){
        if (node == null){
            return 0;
        }else {
            int i = getTreeHeight(node.leftNode);
            int j = getTreeHeight(node.rightNode);
            return i > j ? i + 1 : j + 1;
        }

    }


    /**
     * 求树的节点数
     * @return
     */
    private int getTreeSize(){
        return getTreeSize(rootNode);
    }

    /**
     * 递归方式
     * @param node
     * @return
     */
    private int getTreeSize(TreeNode node){
        if (node == null){
            return 0;
        }else {
            return 1 + getTreeSize(node.leftNode) + getTreeSize(node.rightNode);
        }
    }


    /**
     * 前序遍历 根-左-右
     * 1.递归方式  A-B-D-E-C-F
     * @param node
     */
    private void preOrder(TreeNode node){
        if (node == null){
            return;
        }else {
            System.out.print(" - " + node.data);
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }


    /**
     * 前序遍历
     * 2、基于栈结构遍历
     * @param node
     */
    private void preOrderByStack(TreeNode<String> node){
        Stack<TreeNode<String>> nodes = new Stack<>();
        nodes.push(node);
       while (!nodes.isEmpty()){
           //弹栈
           TreeNode n = nodes.pop();
           System.out.print(" - " + n.data);

           //进栈
           if (n.rightNode != null) {
               nodes.push(n.rightNode);
           }
           if (n.leftNode != null){
               nodes.push(n.leftNode);
           }
       }
    }


    /**
     * 中序遍历 左-根-右
     * D - B - E - A - C - F
     * @param node
     */
    private void midOrder(TreeNode node){
        if (node == null){
            return;
        }else {
            midOrder(node.leftNode);
            System.out.print(" - " + node.data);
            midOrder(node.rightNode);
        }
    }


    /**
     * 后序遍历  左-右-根
     * D-E-B-F-C-A
     * @param node
     */
    private void laterOrder(TreeNode node){
        if (node == null){
            return;
        }else{
            laterOrder(node.leftNode);
            laterOrder(node.rightNode);
            System.out.print(" - " + node.data);
        }
    }


    /**
     * 创建一个完全二叉树
     *  *                    A
     *  *               B        C
     *  *           D      E        F
     * @param rootNode
     */
    public static void createBinaryTree(TreeNode rootNode){
            TreeNode<String> nodeB = new TreeNode<>(2,"B");
            TreeNode<String> nodeC = new TreeNode<>(3,"C");
            TreeNode<String> nodeD = new TreeNode<>(4,"D");
            TreeNode<String> nodeE = new TreeNode<>(5,"E");
            TreeNode<String> nodeF = new TreeNode<>(6,"F");
            rootNode.leftNode = nodeB;
            rootNode.rightNode = nodeC;
            nodeB.leftNode = nodeD;
            nodeB.rightNode = nodeE;
            nodeC.rightNode = nodeF;
    }

    static class TreeNode<T>{
        int index;
        T data;
        TreeNode<T> leftNode;
        TreeNode<T> rightNode;

        public TreeNode(int index, T data) {
            this.index = index;
            this.data = data;
        }
    }

}
