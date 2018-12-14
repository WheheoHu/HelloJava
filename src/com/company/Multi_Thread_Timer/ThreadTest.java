package com.company.Multi_Thread_Timer;

public class ThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            Thread thread=new Thread(new TreadDemo());
            thread.start();
        }
    }
}

class TreadDemo implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("Thread "+Thread.currentThread().getId()+" started.");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}