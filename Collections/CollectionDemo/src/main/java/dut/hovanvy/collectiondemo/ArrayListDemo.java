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
public class ArrayListDemo {
    
    public static void main(String[] args) {
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(9);
        tmpList.add(0);
        
        List<Integer> list = new ArrayList<>(tmpList);
        
        list.add(3);
        list.add(2);
        
        quickSort(list, 0, list.size() - 1);
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    
    public static void quickSort(List<Integer> list, int left, int right) {
        if (right <= left)
            return;
        
        int pivot = list.get((left + right) / 2);
        int index = partition(list, left, right, pivot);
        quickSort(list, left, index - 1);
        quickSort(list, index, right);
    }
    
    public static int partition(List<Integer> list, int left, int right, int pivot) {
        while (left <= right) {
            while (list.get(left) < pivot) {
                left++;
            }
            
            while (list.get(right) > pivot) {
                right--;
            }
            
            if (left <= right) {
                int tmp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, tmp);
                
                left++;
                right--;
            }
        }
        
        return left;
    }
}
