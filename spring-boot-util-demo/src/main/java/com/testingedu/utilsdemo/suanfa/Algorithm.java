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
}
