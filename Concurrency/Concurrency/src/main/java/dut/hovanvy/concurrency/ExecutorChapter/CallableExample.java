/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.concurrency.ExecutorChapter;

import java.util.ArrayList;
import java.util.List;import java.util.concurrent.Future;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author hovanvydut
 * @link https://gpcoder.com/3565-lap-trinh-da-luong-voi-callable-va-future-trong-java/
 */

class CallableWorker implements Callable<Integer> {
    
    private int num;
    private Random random;
    
    public CallableWorker(int num) {
        this.num = num;
        this.random = new Random();
    }
    
    @Override
    public Integer call() throws Exception {
        Thread.sleep(random.nextInt(10) * 1000);
        int result = num * num;
        System.out.println("Complete " + num);
        return result;
    }
}
public class CallableExample {
    public static void main(String[] args) {
        List<Future<Integer>> list = new ArrayList<>();
        
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        Callable<Integer> callable;
        Future<Integer> future;
        for (int i = 1; i <= 10; i++) {
            callable = new CallableWorker(i);
            
            future = executor.submit(callable);
            
            list.add(future);
        }
        
        while (!executor.isTerminated()) {
            
        }
        
        int sum = 0;
        for (Future<Integer> f : list) {
            try {
                sum += f.get();
            } catch (InterruptedException | ExecutionException e) {
                
            }
        }
        
        System.out.println("Finished all threads: ");
        System.out.println("SUM = " + sum);
    }
}
