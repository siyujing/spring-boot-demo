package com.testingedu.utilsdemo.suanfa;

import org.springframework.stereotype.Service;

@Service
public class Algorithm {

    // 二分查找
    public void selectCompare() {
        int a[] = {1, 3, 6, 7, 8, 9};
        int num = 8;
        int str = 0;
        int end = a.length - 1;
        int m = (str + end) / 2;
        while (0 <= m && m <= a.length) {
            if (num == a[m]) {
                System.out.println("m=" + m);
                break;
            }
            if (num > a[m]) {
                str = m + 1;
            }
            if (num < a[m]) {
                end = m - 1;
            }
            m = (str + end) / 2;
        }
    }

    // 冒泡
    public void selectSort() {
        int a[] = {1, 9, 8, 3, 6, 7};
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int tem = a[i];
                    a[i] = a[j];
                    a[j] = tem;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("a=" + a[i]);
        }
    }

    // 递归数组求和
    public static int binarySearch(int[] a, int startIndexIndex, int endIndex) {
        if (startIndexIndex == endIndex) {
            return a[startIndexIndex];
        }
        return a[startIndexIndex] + binarySearch(a, startIndexIndex + 1, endIndex);
    }

    // 递归法实现二分查找
    public static int binarySearch(int[] a, int startIndex, int endIndex, int data) {
        int m = (startIndex + endIndex) / 2;

        if (startIndex > endIndex) {
            return -1;
        }

        if (a[m] == data) {
            return m;
        }

        if (a[m] > data) {
            return binarySearch(a, startIndex, m - 1, data);
        }

        if (a[m] < data) {
            return binarySearch(a, m + 1, endIndex, data);
        }
        return -1;
    }
}
