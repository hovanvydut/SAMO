/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.concurrency.GuardedBlockChapter;

import java.util.Random;

/**
 *
 * @author hovanvydut
 * @link https://docs.oracle.com/javase/tutorial/essential/concurrency/guardmeth.html
 */

class Drop {
    // Message sent from producer
    // to consumer.
    private String message;
    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty = true;
    
    // Consumer take message if message is not empty
    public synchronized String take() {
        // if message emtpy --> wait
        while (empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                
            }
        }
        
        // Toggle status
        empty = true;
        // Notify producer that consumer taken message
        this.notifyAll();
        return message;
    }
    
    public synchronized void put(String msg) {
        // Wait until message has
        // been retrieved.
        while (!empty) {
            try {
                this.wait();
            } catch (InterruptedException e) {}
        }
        
        // Toggle status empty = false;
        empty = false;
        this.message = msg;
        this.notifyAll();
    }
}

class Producer implements Runnable {
    private Drop drop;
    
    public Producer(Drop drop) {
        this.drop = drop;
    }
    
    @Override
    public void run() {
        String[] messages = {"A", "B", "C", "D", "E", "F"};
        Random random = new Random();
        
        for (String msg : messages) {
            drop.put(msg);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
        
        drop.put("DONE");
    }
}

class Consumer implements Runnable {
    private Drop drop;
    
    public Consumer(Drop drop) {
        this.drop = drop;
    }
    
    @Override
    public void run() {
        Random random = new Random();
        for (String msg = this.drop.take(); !(msg.equals("DONE")); msg = this.drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", msg);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}
public class ProducerConsumer {
    public static void main(String[] args) {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
