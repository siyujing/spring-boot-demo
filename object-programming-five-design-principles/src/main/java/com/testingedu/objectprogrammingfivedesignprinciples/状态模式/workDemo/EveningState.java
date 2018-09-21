package com.testingedu.objectprogrammingfivedesignprinciples.状态模式.workDemo;


// 上午状态
public class EveningState extends State {

    @Override
    public void writeProject(Work work) {
        if (work.isFinished()) {
            work.setCurrentState(new RestState());
            work.writeProgrammer();
        }

        if (work.getHour() <= 21) {
            System.out.println("傍晚" + work.getHour() + " 点加班，疲惫。。。");

        } else {
            work.setCurrentState(new SleepingState());
            work.writeProgrammer();
        }
    }
}
