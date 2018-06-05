package com.lify.statictest.basic.thread;

public class TestVolatile {

    private volatile int number = 0;

    public void increase() {
        this.number++;
    }

    public int getNumber() {
        return this.number;
    }

    public static void main(String[] args) {

        TestVolatile testVolatile = new TestVolatile();

        for(int i =0;i<500;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    testVolatile.increase();
                    System.out.println(testVolatile.getNumber());
                }
            }).start();
        }
        while(Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println("number:" + testVolatile.getNumber());
    }

}
