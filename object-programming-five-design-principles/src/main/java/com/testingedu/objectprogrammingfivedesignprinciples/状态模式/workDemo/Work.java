package com.testingedu.objectprogrammingfivedesignprinciples.状态模式.workDemo;

import lombok.Data;

@Data
public class Work {
    private State currentState;
    private double hour;
    private boolean finished;

    public void writeProgrammer() {
        currentState.writeProject(this);
    }

    public Work() {
        currentState = new ForenoonState();    // 工作状态初始化为上午工作状态
    }
}
