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
public class HashMapDemo {
    
    public static void main(String[] args) {
        
        /*
        * Solution Leetcode #1
        */
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        boolean checked = false;
        for (int i = 0; i < nums.length; i++) {
            if (map.getOrDefault(target-nums[i], -1) != -1) {
                System.out.println("[" + nums[i] + ", " + map.get(target-nums[i]) + "]");
                checked = true;
                break;
            }
        }
        
        if (!checked) {
            System.out.println("Khong co cap so nao thoa man");
        }
    }
    
}
