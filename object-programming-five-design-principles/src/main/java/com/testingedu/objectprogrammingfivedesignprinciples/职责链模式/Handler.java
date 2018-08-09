package com.testingedu.objectprogrammingfivedesignprinciples.职责链模式;

public abstract class Handler {

    protected Handler successor;        // 下一个节点的处理者

    /**
     * 请求处理
     *
     * @param condition 请求条件
     */
    public abstract void handlerRequest(String condition);
}
