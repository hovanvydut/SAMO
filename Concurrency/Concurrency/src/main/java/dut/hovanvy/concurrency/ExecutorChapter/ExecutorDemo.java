/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.concurrency.ExecutorChapter;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 *
 * @author hovanvydut
 * @link https://kipalog.com/posts/Kha-i-nie--m-ThreadPool-va--Executor-trong-Java
 */

class RequestHandler implements Runnable {
    
    String name;
    
    public RequestHandler(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " starting process " + name);
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " finished process " + name);
        } catch (InterruptedException e) {
            
        }
    }
}

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 100; i++) {
            executor.execute(new RequestHandler("request " + i));
        }
        executor.shutdown();
        
        while (!executor.isTerminated()) {
            
        }
    }
}
