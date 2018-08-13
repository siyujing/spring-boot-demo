package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂.service;

import com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂.*;
import com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂.entity.Department;
import com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂.entity.User;
import org.springframework.stereotype.Service;

@Service
public class ClientAbstrictService {

    public void test() {
        User newUser = new User();
        IFactory factory = new SqlServerFactory();
        IUser user = factory.createUser();
        user.insert(newUser);
    }

    public void test2() {
        IFactory factory = new AccessFactory();
        IDepartment department = factory.createDepartment();
        department.findByDepartmentId();
    }
}
