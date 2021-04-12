/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.concurrency.SynchronizationChapter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author hovanvydut
 */
public class ReentrantLockDemo {
    
    private static ReentrantLock lock = new ReentrantLock(true);
    
    private static void accessResource0() {
        lock.lock();
        try {
            
        } finally {
            lock.unlock();
        }
    }
    
    private static void accessResouce1() {
        boolean lockAcquired = lock.tryLock();
        
        if (lockAcquired) {
            try {
                
            } finally {
                lock.unlock();
            }
        } else {
            // do alternate thing
        }
    }
    
    private static void accessResouce2() throws InterruptedException {
        boolean lockAcquired = lock.tryLock(5, TimeUnit.SECONDS);
        
        if (lockAcquired) {
            try {
                
            } finally {
                lock.unlock();
            }
        } else {
            // do alternate thing
        }
    }
    
    public static void main(String[] args) {
        Thread t0 = new Thread(() -> accessResource0()); t0.start();
        Thread t1 = new Thread(() -> accessResource0()); t1.start();
        Thread t2 = new Thread(() -> accessResource0()); t2.start();
        Thread t3 = new Thread(() -> accessResource0()); t3.start();
    }
}
