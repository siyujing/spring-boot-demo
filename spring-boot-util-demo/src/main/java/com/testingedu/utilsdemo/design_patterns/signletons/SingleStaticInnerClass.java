package com.testingedu.utilsdemo.design_patterns.signletons;

/**
 * 使用静态内部类，较常用
 */
public class SingleStaticInnerClass {
    private SingleStaticInnerClass() {
    }

    public static class InnerHolder {
        private static final SingleStaticInnerClass single = new SingleStaticInnerClass();
    }

    public static SingleStaticInnerClass getInstance() {
        return InnerHolder.single;
    }
}
