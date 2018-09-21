package com.testingedu.objectprogrammingfivedesignprinciples.状态模式.workDemo;

// 下午状态
public class AfternoonState extends State {

    @Override
    public void writeProject(Work work) {
        if (work.getHour() < 17) {
            System.out.println("下午工作时间，继续努力。");

        }else {
                work.setCurrentState(new EveningState());
                work.writeProgrammer();
        }
    }
}
