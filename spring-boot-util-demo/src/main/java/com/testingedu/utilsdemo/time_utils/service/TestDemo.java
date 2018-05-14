package com.testingedu.utilsdemo.time_utils.service;

import java.util.Enumeration;
import java.util.Hashtable;

public class TestDemo {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Hashtable hashtable = new Hashtable();

        hashtable.put("a", "aa");
        hashtable.put("b", "bb");

        Enumeration keys = hashtable.keys();
        while (keys.hasMoreElements()){
            Object o = keys.nextElement();
            System.out.println(o+":"+hashtable.get(o));
        }
    }
}
