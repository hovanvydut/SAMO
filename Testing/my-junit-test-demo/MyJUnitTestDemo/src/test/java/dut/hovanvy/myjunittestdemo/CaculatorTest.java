/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dut.hovanvy.myjunittestdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 *
 * @author hovanvydut
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CaculatorTest {
    private Caculator caculator;
    
    @BeforeAll
    public void initAll() {
        System.out.println("@BeforeAll");
        this.caculator = new Caculator();
    }
    
    @BeforeEach
    public void init() {
        System.out.println("@BeforeEach");
    }
    
    @Test
    @DisplayName("1 + 1 = 2")
    public void addTwoNumbers() {
        System.out.println("addTwoNumbers");
        Assertions.assertEquals(2, this.caculator.add(1, 1), "1 + 1 should be equal 2");
    }
    
    @Test
    @DisplayName("a * b")
    public void multiplyTwoNumber() {
        System.out.println("multiplyTwoNumber");
        Assertions.assertEquals(8, this.caculator.multiply(2, 4), "4 * 2 should be equal 8");
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("@AfterEach");
    }
    
    @AfterAll
    public void tearDownAll() {
        System.out.println("@AfterAll");
    }
}
