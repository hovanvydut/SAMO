/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.concurrency.ExecutorChapter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author hovanvydut
 * @link https://viblo.asia/p/lap-trinh-da-luong-voi-completablefuture-trong-java-8-6J3ZgBMLKmB#_ket-hop-hai-future-phu-thuoc-su-dung-thencompose-11
 */

class User {
    String userId;
    
    public User(String userId) {
        this.userId = userId;
    }
}

class UserService {
    public static User getUserDetails(String userId) {
        return new User(userId);
    }
}

class CreditRatingService {
    public static Double getCreditRating(User user) {
        return Double.parseDouble(user.userId);
    }
}

class APIUtils {
    public static CompletableFuture<User> getUserDetails(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return UserService.getUserDetails(userId);
        });
    }
    
    public static CompletableFuture<Double> getCreditRating(User user) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return CreditRatingService.getCreditRating(user);
        });
    }
}

public class CompletableFutureExample3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Double> future = APIUtils.getUserDetails("1")
                .thenCompose(user -> APIUtils.getCreditRating(user));
        
        System.out.println(future.get());
        
    }
}
