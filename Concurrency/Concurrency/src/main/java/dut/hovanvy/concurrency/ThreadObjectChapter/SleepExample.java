/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.concurrency.ThreadObjectChapter;

/**
 *
 * @author DELL
 */
public class SleepExample {
    
    public static void main(String[] args) {
        Thread t0 = new Thread(new TestSleep());
        Thread t1 = new Thread(new TestSleep());
        
        System.out.println(Thread.currentThread().getName() + " before running thread 0, 1");
        t0.start();
        t1.start();
    }
    
    private static class TestSleep implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(1000); // When this thread's sleeping, scheduler can pick up another thread to running
                } catch (InterruptedException e) {
                    
                }
                
                System.out.println(Thread.currentThread().getName() + " running - " + i + " times");
            }
        }
    }
}
