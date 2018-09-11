package com.testingedu.utilsdemo.suanfa;

import lombok.Data;

/**
 * 注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
 */
public class BinatyTree {

    // 初始化一个树，初始化时必须逆序 即先定义叶子
    public static Node initNode() {
        Node G = new Node(2, null, null);
        Node H = new Node(4, null, null);
        Node J = new Node(8, null, null);
        Node D = new Node(1, null, G);
        Node E = new Node(5, H, null);
        Node F = new Node(7, null, J);
        Node B = new Node(3, D, E);
        Node C = new Node(9, F, null);
        Node A = new Node(6, B, C);

        return A;
    }


    // 递归先序遍历
    public static void theFirstTraversal(Node node) {
        System.out.println(node.getDate()); // 输出根节点

        // 遍历左孩子
        if (node.getLeftNode() != null) {
            theFirstTraversal(node.getLeftNode());
        }

        // 遍历右孩子
        if (node.getRightNode() != null) {
            theFirstTraversal(node.getRightNode());
        }
    }

    // 递归中序遍历
    public static void theInOrderTraversal(Node node) {
        if (node.getLeftNode() != null) {
            theInOrderTraversal(node.getLeftNode());
        }

        System.out.println(node.getDate()); // 输出根节点

        if (node.getRightNode() != null) {
            theInOrderTraversal(node.getRightNode());
        }
    }

    // 递归后续遍历
    public static void thePostOrderTraversal(Node node) {
        if (node.getLeftNode() != null) {
            thePostOrderTraversal(node.getLeftNode());
        }

        if (node.getRightNode() != null) {
            thePostOrderTraversal(node.getRightNode());
        }

        System.out.println(node.getDate()); // 输出根节点
    }



    // 创建一个树
    @Data
    public static class Node {
        private int date; // 根节点
        private Node leftNode;
        private Node rightNode;

        public Node(int date, Node leftNode, Node rightNode) {
            this.date = date;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
}
