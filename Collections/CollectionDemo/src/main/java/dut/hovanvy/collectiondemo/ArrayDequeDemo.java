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
public class ArrayDequeDemo {

    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<String>();
        deque.offer("arvind");
        deque.offer("vimal");
        deque.add("mukul");
        deque.offerFirst("jai");

        System.out.println("After offerFirst Traversal...");
        for (String s : deque) {
            System.out.println(s);
        }
    }
}
