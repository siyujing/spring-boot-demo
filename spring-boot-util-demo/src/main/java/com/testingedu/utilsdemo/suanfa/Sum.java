package com.testingedu.utilsdemo.suanfa;

/**
 * 计算连数求和等于给定的某一个值；
 * 如等于9 的连续数：2+3+4=9;4+5=9
 */
public class Sum {
    static int[] SUM;

    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int data = 0;
        sumN((data >> 1) + 1);
        while (i <= ((data >> 1) + 1)) {
            if (data == 0) {
                System.out.println("end");
                return;
            }
            if (SUM[i] - SUM[j] == data && (j + 1) != i) {
                System.out.println(j + 1 + " " + i);
                i++;
            } else if (SUM[i] - SUM[j] > data) {
                j++;
            } else {
                i++;
            }
        }
        System.out.println("end");
    }

    // 计算出所有从1开始的连续数的和，num 是给定连续数(data/2)+1
    public static void sumN(int num) {
        SUM = new int[num + 1];
        int i = 1;
        while (i <= num) {
            SUM[i] = ((1 + i) * i) >> 1;
            i++;
        }
    }
}
