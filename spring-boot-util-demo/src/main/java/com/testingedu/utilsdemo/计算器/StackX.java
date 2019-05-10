package com.testingedu.utilsdemo.计算器;

import lombok.Data;

@Data
public class StackX {

    private Integer maxSize;
    private char[] stackArray;
    private Integer top;


    public StackX(Integer maxSize) {
        this.maxSize = maxSize;
        stackArray = new char[2];
        top = -1;
    }

    public void push(char j) {
        stackArray[++top] = j;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public char peekN(Integer j) {
        return stackArray[j];
    }

    public Integer size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void displayStack(String s) {
        System.out.println(s);
        System.out.println("Stack (bottom-->top):");
        for (int i = 0; i < size(); i++) {
            System.out.println(peekN(i));
            System.out.println(' ');
        }
        System.out.println("");
    }
}
