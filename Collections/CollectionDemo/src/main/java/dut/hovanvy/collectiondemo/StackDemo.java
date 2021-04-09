/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.collectiondemo;

import java.util.*;

/**
 *
 * @author DELL
 */

public class StackDemo {
    
    public static void main(String[] args) {
        /*
         * Solution 682. Baseball Game on leetcode 
         */
        
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        
        Map<Character, Character> dict = new HashMap<>();
        dict.put('(', ')');
        dict.put('[', ']');
        dict.put('{', '}');
        
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                char top = !stack.isEmpty() ? stack.peek() : '1';
                if (top != '1' && dict.get(top) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
}
