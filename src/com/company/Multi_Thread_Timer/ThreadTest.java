package com.company.Multi_Thread_Timer;

public class ThreadTest {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 8; i++) {
                Thread thread = new Thread(new TreadDemo());
                thread.start();
                thread.sleep(1000);
            }
        }
        catch(Exception e){
            e.printStackTrace();
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