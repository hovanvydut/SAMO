/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.optional;

import java.util.Optional;

/**
 *
 * @author hovanvydut
 */
public class Demo {

    public static void main(String[] args) {
        Optional<String> hello = Optional.ofNullable(null);

        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

//        String orElse = hello
//                .map(String::toUpperCase)
//                .orElse("world");
//        String orElse = hello
//                .map(String::toUpperCase)
//                .orElseGet(() -> {
//                    // ... extra computation to retrieve value
//                    String world = "world";
//                    world += "!";
//                    return world;
//                });
//        String orElse = hello
//                .map(String::toUpperCase)
//                .orElseThrow(IllegalStateException::new);
//        System.out.println(orElse);
        
//        hello
//                .ifPresent(System.out::println);


        hello.ifPresentOrElse(System.out::println, () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("world!");
        });
    }
}
