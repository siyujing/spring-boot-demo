package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂;

public class AccessFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new AccessUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new AccessDepartment();
    }
}
