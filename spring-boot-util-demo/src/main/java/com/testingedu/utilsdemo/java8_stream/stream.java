package com.testingedu.utilsdemo.java8_stream;

import lombok.Data;

import java.util.*;

public class stream {


    static List<Student> studentList = new ArrayList<>();

    public static LinkedList<Student> sort() {
        LinkedList<Student> collect = studentList.stream()
                .filter(student -> Objects.nonNull(student.getAge()))
                .sorted((student1, student2) -> (student1.getAge() - student2.getAge()))    // 等价于 .sorted(Comparator.comparing(student ->student.getAge() ))
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        System.out.println(collect);
        return collect;
    }

    @Data
    public static class Student {
        private String name;
        private int age;
    }
}
