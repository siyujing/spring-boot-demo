package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂;

import com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂.entity.User;

public class AccessUser implements IUser{
    @Override
    public void insert(User user) {
        System.out.println("AccessUser insert one");
    }

    @Override
    public User getUser() {
        System.out.println("AccessUser select one");
        return new User();
    }
}
