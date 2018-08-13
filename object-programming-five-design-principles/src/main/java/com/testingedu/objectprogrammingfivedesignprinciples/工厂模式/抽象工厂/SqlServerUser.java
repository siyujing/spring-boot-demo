package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂;


import com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂.entity.User;

public class SqlServerUser implements IUser {
    @Override
    public void insert(User user) {
        System.out.println("sqlServerUser insert one");
    }

    @Override
    public User getUser() {
        System.out.println("sqlServerUser select one");
        return new User();
    }
}
