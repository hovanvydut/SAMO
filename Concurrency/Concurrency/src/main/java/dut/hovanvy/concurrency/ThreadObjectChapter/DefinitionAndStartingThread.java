/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.concurrency.ThreadObjectChapter;

/**
 *
 * @author hovanvydut
 */

class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from a thread.");
    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from a thread");
    }
}

public class DefinitionAndStartingThread {
    public static void main(String[] args) {
        (new Thread(new HelloRunnable())).start();
        (new Thread()).start();
    }
}
