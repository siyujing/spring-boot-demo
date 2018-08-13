package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂;

import com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂.entity.User;

public interface IUser {
    void insert(User user);

    User getUser();
}
