package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂;

public interface IFactory {
    IUser createUser();

    IDepartment createDepartment();
}
