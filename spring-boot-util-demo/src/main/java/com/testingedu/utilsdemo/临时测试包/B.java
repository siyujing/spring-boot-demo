package com.testingedu.utilsdemo.临时测试包;


public class B implements Runnable {

    Timer timer = new Timer();

    public static void main(String[] args) {
        B b1 = new B();
        Thread t1 = new Thread(b1);
        B b2= new B();
        Thread t2 = new Thread(b2);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        timer.add(Thread.currentThread().getName());
    }

    static class Timer {
        private static volatile int num = 0;

        public synchronized static int getNum() {
            return num;
        }

        public synchronized static void setNum(int num) {
            Timer.num = num;
        }

        public void add(String name) {
            synchronized (Timer.class) {
                setNum(++num);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + ",你是第" + getNum() + "个使用timer 的线程");
            }
        }

    }

}
