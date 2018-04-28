package com.testingedu.utilsdemo.test_volatile;

/**
 * 不会死循环
 * */
public class Task2 implements Runnable {
    private boolean running = true;
    int i = 0;

    @Override
    public void run() {
        while (this.isRunning()) {
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task2 task = new Task2();
        Thread th = new Thread(task);
        th.start();

        Thread.sleep(100);
        System.out.println(task.i);

        Thread.sleep(100);
        task.setRunning(false);

        Thread.sleep(1);
        System.out.println(task.i);

        Thread.sleep(1000);
        System.out.println(task.i);

    }


    public synchronized boolean isRunning() {
        return running;
    }

    public synchronized Task2 setRunning(boolean running) {
        this.running = running;
        return this;
    }
}
