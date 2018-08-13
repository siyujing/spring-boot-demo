package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂;

import com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂.entity.Department;

public class SqlServerDepartment implements IDepartment {
    @Override
    public void indertDepartment() {
        System.out.println("SqlServerDepartment, insert one");
    }

    @Override
    public Department findByDepartmentId() {
        System.out.println("SqlServerDepartment, find one");
        return new Department();
    }
}
