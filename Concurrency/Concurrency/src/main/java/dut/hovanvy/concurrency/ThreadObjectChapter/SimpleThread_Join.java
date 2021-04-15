/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.concurrency.ThreadObjectChapter;

/**
 *
 * @author hovanvydut
 */

public class SimpleThread_Join {
    
    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }
    
    private static class MessageLoop implements Runnable{
        @Override
        public void run() {
            String[] importantInfo = {"A", "B", "C", "D", "E", "F"};
            
            try {
                for (int i = 0; i < importantInfo.length; i++) {
                    Thread.sleep(4000);
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        long patience = 1000 * 3 * 1;
        
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Arguments must be an integer");
            }
        }
        
        threadMessage("Starting MessageLoop thread");
        
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();
        
        threadMessage("Waiting for MessageLoop thread to finish");
        
        while (t.isAlive()) {
            threadMessage("Still waiting ...");
            t.join(1000); // main thread waiting "t thread" dead or timeout
            
            if (((System.currentTimeMillis() - startTime) >  patience) && t.isAlive()) {
                threadMessage("Tired for waiting!");
                t.interrupt();
                t.join(); // main thread waiting "t thread" dead or timeout
            }
        }
        threadMessage("Finally!");
    }
}
