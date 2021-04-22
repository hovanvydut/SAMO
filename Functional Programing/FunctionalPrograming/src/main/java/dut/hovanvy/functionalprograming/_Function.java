/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.functionalprograming;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *
 * @author hovanvydut
 * @link https://www.youtube.com/watch?v=VRpHdSFWGPs&t=1263s
 */
public class _Function {
    public static void main(String[] args) {
        int i = incrementByOne.andThen(multiplyBy10).apply(10);
        int j = incrementByOneAndMultiply.apply(10, 2);
        
        System.out.println(i);
        System.out.println(j);
    }
    
    static Function<Integer, Integer> incrementByOne = number -> number + 1;
    static Function<Integer, Integer> multiplyBy10 = number -> number * 10;
    
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply =
            (a, b) -> (a + 1) * b;
    
}
