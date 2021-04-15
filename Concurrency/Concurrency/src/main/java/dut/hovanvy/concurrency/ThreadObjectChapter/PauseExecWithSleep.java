/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.concurrency.ThreadObjectChapter;

/**
 *
 * @author DELL
 */
public class PauseExecWithSleep {

    public static void main(String[] args) throws InterruptedException {
        (new SleepMessages()).testSleep();
    }

    static class SleepMessages {

        public void testSleep() throws InterruptedException {
            String[] importantInfo = {"A", "B", "C", "D", "E", "F", "G"};

            for (int i = 0; i < importantInfo.length; i++) {
                Thread.sleep(4000);
                System.out.println(importantInfo[i]);
            }
        }

    }
}
