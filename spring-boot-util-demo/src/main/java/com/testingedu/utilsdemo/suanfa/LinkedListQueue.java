package com.testingedu.utilsdemo.suanfa;

import lombok.Data;

import java.io.IOException;
import java.util.LinkedList;


// 双向列表
@Data
public class LinkedListQueue {
    private QueueNode front;     // 队列的前端指针
    private QueueNode rear;      // 队列的尾端指针


    //构造函数
    public LinkedListQueue() {
        front = null;
        rear = null;
    }


    public boolean enqueue(int action, int value) {
        QueueNode node = new QueueNode(value); //建立节点
        if (action == 1) {
            if (rear == null) {
                front = node;
                rear = node;
            } else {
                node.next = front;
                front = node;
            }
            return true;
        } else if (action == 2) {
            if (rear == null) {
                front = node;
                rear = node;
            } else {
                rear.next = node;
                rear = node;
            }
            return true;
        } else {
            return false;
        }
    }

    //方法dequeue:队列数据的取出
    public int dequeue(int action) {
        int value;
        QueueNode tempNode, startNode;
        //从前端取出数据
        if (!(front == null) && action == 1) {
            if (front == rear) {
                value = front.data; //将队列数据从前端取出
                front = null;
                rear = null;
            } else {
                value = front.data;
                front = front.next;
            }
            return value;
        } else if (!(rear == null) && action == 2) {  //从尾端取出数据
            if (front == rear) {
                value = rear.data;
                front = null;
                rear = null;
            } else {
                value = rear.data;
                tempNode = front;
                while (tempNode.next != rear) {
                    //tempNode=startNode.next;
                    tempNode = tempNode.next;
                }
                rear = tempNode;
            }
            return value;
        } else {
            return -1;
        }
    }

    public static void main(String args[]) throws IOException {
        LinkedListQueue queue = new LinkedListQueue(); //建立队列对象
        int temp;
        System.out.println("以链表来实现双向队列");
        System.out.println("====================================");
        System.out.println("在双向队列前端加入第1个数据，此数据值为1");
        queue.enqueue(1, 4);
        System.out.println("在双向队列前端加入第2个数据，此数据值为3");
        queue.enqueue(1, 3);
        System.out.println("在双向队列前端加入第3个数据，此数据值为5");
        queue.enqueue(2, 5);
        System.out.println("在双向队列前端加入第4个数据，此数据值为7");
        queue.enqueue(1, 7);
        System.out.println("在双向队列前端加入第5个数据，此数据值为9");
        queue.enqueue(2, 9);
        System.out.println("====================================");
        temp = queue.dequeue(1);
        System.out.println("从双向队列前端依序取出的元素数据值为：" + temp);
        temp = queue.dequeue(2);
        System.out.println("从双向队列尾端依序取出的元素数据值为：" + temp);
        temp = queue.dequeue(1);
        System.out.println("从双向队列前端依序取出的元素数据值为：" + temp);
        temp = queue.dequeue(2);
        System.out.println("从双向队列尾端依序取出的元素数据值为：" + temp);
        temp = queue.dequeue(1);
        System.out.println("从双向队列前端依序取出的元素数据值为：" + temp);
        System.out.println();
    }


    @Data
    public static class QueueNode {
        private int data;
        private QueueNode next;

        public QueueNode(int data) {
            this.data = data;
        }

        public QueueNode() {
        }
    }
}
