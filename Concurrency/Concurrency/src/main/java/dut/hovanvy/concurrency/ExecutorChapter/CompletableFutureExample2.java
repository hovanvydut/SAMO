/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.concurrency.ExecutorChapter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 *
 * @author hovanvydut
 * @link https://viblo.asia/p/lap-trinh-da-luong-voi-completablefuture-trong-java-8-6J3ZgBMLKmB
 */

class MathUtil {
    public static int times(int num, int times) {
        return num * times;
    }
    
    public static int square(int num) {
        return num * num;
    }
    
    public static boolean isEven(int num) {
        return (num % 2) == 0;
    }
}

public class CompletableFutureExample2 {
    
    public static final int NUMBER = 5;
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> times2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {}
            
            return MathUtil.times(NUMBER, 2);
        });
        
        CompletableFuture<Boolean> greetingFuture = times2.thenApply(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return MathUtil.square(n);
            }
        })
        .thenApply(n -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException e) {}
            
            return MathUtil.isEven(n);
        });
        
        System.out.println(greetingFuture.get());
    }
}
