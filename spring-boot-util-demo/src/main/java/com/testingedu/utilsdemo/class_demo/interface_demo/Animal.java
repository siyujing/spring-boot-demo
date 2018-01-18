package com.testingedu.utilsdemo.class_demo.interface_demo;

/**
 *            1：接口不可实例化，可结合多态进行使用(接口 对象=new 对象())

 　　　　　　　　2：接口里的成员属性全部是以 public(公开)、static(静态)、final(最终) 修饰符修

 　　　　　　　　3：接口里的成员方法全部是以 public(公开)、abstract(抽象) 修饰符修

 　　　　　　　　4：接口里不能包含普通方法

 　　　　　　　　5：子类继承接口必须实现接口里的所有成员方法，除非子类也是抽象
 * */

public interface Animal {
    String cry = "大叫";
    String run = "快跑";

    String startCry();
    public String startRun();
}
