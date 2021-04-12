/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.concurrency.SynchronizationChapter;

/**
 *
 * @author hovanvydut
 */
public class ThreadInterference {
    
    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();
        
        Thread t1 = new Thread(() -> {
            counter.increment(); // run 1st
            System.out.println(counter.value()); // run 4rd ==> "0"
        });
        
        Thread t2 = new Thread(() -> {
            counter.decrement(); // run 2nd
            System.out.println(counter.value()); // run 3rd ==> "0"
        });
        
        t1.start();
        t2.start();
    }

    static class SynchronizedCounter {

        private int c = 0;

        public synchronized void increment() {
            c++;
        }

        public synchronized void decrement() {
            c--;
        }

        public synchronized int value() {
            return c;
        }
    }
}
