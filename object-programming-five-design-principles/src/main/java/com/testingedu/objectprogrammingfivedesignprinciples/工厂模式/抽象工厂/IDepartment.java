package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂;

import com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂.entity.Department;

public interface IDepartment {
    void indertDepartment();

    Department findByDepartmentId();
}
