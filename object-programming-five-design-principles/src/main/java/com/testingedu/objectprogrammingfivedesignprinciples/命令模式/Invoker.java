package com.testingedu.objectprogrammingfivedesignprinciples.命令模式;

/**
 * 请求者类
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    /**
     * 调用具体命令对象的相关方法，执行具体的命令
     */
    public void action() {
        command.execute();
    }
}
