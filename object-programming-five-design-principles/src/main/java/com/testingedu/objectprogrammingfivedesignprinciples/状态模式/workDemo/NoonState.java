package com.testingedu.objectprogrammingfivedesignprinciples.状态模式.workDemo;

// 中午状态
public class NoonState extends State {

    @Override
    public void writeProject(Work work) {
        if (work.getHour() < 13) {
            System.out.println("午休时间，好好休息，养精蓄锐。");
        } else {
            work.setCurrentState(new AfternoonState());
            work.writeProgrammer();
        }
    }
}
