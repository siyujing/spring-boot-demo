package com.testingedu.utilsdemo.suanfa;

import com.testingedu.utilsdemo.demo_packet.ForTestDemo;
import lombok.Data;

/**
 * 注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
 */
public class BinatyTree {

    // 初始化一个树，初始化时必须逆序 即先定义叶子
    public static ForTestDemo.Node initNode() {
        ForTestDemo.Node G = new ForTestDemo.Node(2, null, null);
        ForTestDemo.Node H = new ForTestDemo.Node(4, null, null);
        ForTestDemo.Node J = new ForTestDemo.Node(8, null, null);
        ForTestDemo.Node D = new ForTestDemo.Node(1, null, G);
        ForTestDemo.Node E = new ForTestDemo.Node(5, H, null);
        ForTestDemo.Node F = new ForTestDemo.Node(7, null, J);
        ForTestDemo.Node B = new ForTestDemo.Node(3, D, E);
        ForTestDemo.Node C = new ForTestDemo.Node(9, F, null);
        ForTestDemo.Node A = new ForTestDemo.Node(6, B, C);

        return A;
    }


    // 递归先序遍历
    public static void theFirstTraversal(ForTestDemo.Node node) {
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

    // 递归先序遍历
    public static void theInOrderTraversal(ForTestDemo.Node node) {
        if (node.getLeftNode() != null) {
            theInOrderTraversal(node.getLeftNode());
        }

        System.out.println(node.getDate()); // 输出根节点

        if (node.getRightNode() != null) {
            theInOrderTraversal(node.getRightNode());
        }
    }

    // 递归后续遍历
    public static void thePostOrderTraversal(ForTestDemo.Node node) {
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
        private ForTestDemo.Node leftNode;
        private ForTestDemo.Node rightNode;

        public Node(int date, ForTestDemo.Node leftNode, ForTestDemo.Node rightNode) {
            this.date = date;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
}
