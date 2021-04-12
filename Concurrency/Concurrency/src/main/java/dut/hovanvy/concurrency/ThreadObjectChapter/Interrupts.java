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
public class Interrupts {
    
    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    threadMessage("Thread is not interrupted");
                }
                threadMessage("Thread is interrupted");
            }
        });
        
        threadMessage("starting thread2");
        thread2.start();
        Thread.sleep(10); // sleep "main thread" 10 miliseconds
        // phải mất một khoảng thời gian thì thread2 mới interrupt hoàn toàn, nên hàm main chạy câu lệnh phía dưới trước khi log ra màn hình "Thread is interrupted"
        thread2.interrupt(); 
        threadMessage("Finish");
        
//        (new SleepMessages()).testSleep();
    }

    static class SleepMessages {

        public void testSleep() {
            String[] importantInfo = {
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G"
            };

            for (int i = 0; i < importantInfo.length; i++) {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    return;
                }
                System.out.println(importantInfo[i]);
            }
        }

    }
}
