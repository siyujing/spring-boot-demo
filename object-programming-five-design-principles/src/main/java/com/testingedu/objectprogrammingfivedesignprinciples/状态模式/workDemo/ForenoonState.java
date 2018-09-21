package com.testingedu.objectprogrammingfivedesignprinciples.状态模式.workDemo;

// 上午状态
public class ForenoonState extends State {

    @Override
    public void writeProject(Work work) {
        if (work.getHour() < 12) {
            System.out.println("上午时间，努力工作，精神倍好");

        } else {
            work.setCurrentState(new NoonState());
            work.writeProgrammer();
        }
    }
}
