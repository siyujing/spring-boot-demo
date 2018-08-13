package com.testingedu.objectprogrammingfivedesignprinciples.工厂模式.抽象工厂;


public class SqlServerFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new SqlServerUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new SqlServerDepartment();
    }
}
