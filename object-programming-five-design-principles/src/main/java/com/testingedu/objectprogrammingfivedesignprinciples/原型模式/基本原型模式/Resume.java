package com.testingedu.objectprogrammingfivedesignprinciples.原型模式.基本原型模式;



public abstract class Resume {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;

    public abstract Resume clone();
}
