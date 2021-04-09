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
public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> myLinkedList = new LinkedList<>();
        addData(myLinkedList);
        show(myLinkedList);
        
        // use Iterator to remove
        Iterator<String> it = myLinkedList.iterator();
        String s = "";
        while (it.hasNext()) {
            s = (String) it.next();
            if ("C".equals(s)) {
                it.remove();
            }
        }
        show(myLinkedList);

        // use ListIterator to add
        ListIterator<String> listIt = myLinkedList.listIterator();
        while (listIt.hasNext()) {
            String str = (String) listIt.next();
            if ("B".equals(str)) {
                listIt.add("Z");
            }
        }
        show(myLinkedList);
        
        // UseListIterator to remove
        ListIterator<String> listIt2 = myLinkedList.listIterator();
        while (listIt2.hasNext()) {
            String str = (String) listIt2.next();
            if ("Z".equals(str)) {
                listIt2.remove();
            }
        }
        show(myLinkedList);

        myLinkedList.clear();
    }
    
    public static void addData(List<String> list) {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
    }
    
    public static void show(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("=====");
    }
}
