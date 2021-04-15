/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.concurrency.ExecutorChapter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author hovanvydut
 * @link https://viblo.asia/p/lap-trinh-da-luong-voi-completablefuture-trong-java-8-6J3ZgBMLKmB
 */
public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("=========");
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        
        completableFuture.complete(computeSomething());
        
        System.out.println("Get the result: ");
        String result = completableFuture.get();
        System.out.println(result);
        
        System.out.println("=========");
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                
            }
        });
        
        System.out.println("It's also running");
        future2.get();
        System.out.println("Done");
        
        System.out.println("===========");
        CompletableFuture<String> future3 = CompletableFuture.<String>supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                
            }
            
            return "Completed";
        });
        
        System.out.println("It is also running... ");
        // block and wait for the future to complete
        System.out.println("Result: " + future3.get());
        System.out.println("Done!!!");
        
        System.out.println("=========");
    }
    
    public static String computeSomething() {
        try {
            System.out.println(Thread.currentThread().getName() + " Computing ...");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " Compute completed ...");
        } catch (InterruptedException e) {}
        
        return "Future's result";
    }
}
