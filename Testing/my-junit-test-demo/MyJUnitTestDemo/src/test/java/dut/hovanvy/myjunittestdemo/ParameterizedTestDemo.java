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
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author DELL
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTestDemo {
    
    private final Caculator caculator = new Caculator();
    
    @BeforeAll
    public void initAll() {
        System.out.println("@BeforeAll");
    }
    
    @BeforeEach
    public void init() {
        System.out.println("@BeforeEach");
    }
    
    @ParameterizedTest
    @CsvSource({
        "1, 1, 1",
        "2, 2, 4",
        "4, 4, 16",
        "8, 8, 64"
    })
    public void multiply(int a, int b, int expectedResult) {
        Assertions.assertEquals(this.caculator.multiply(a, b), expectedResult);
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println("tearDown");
    }
    
    @AfterAll
    public void tearDownAll() {
        System.out.println("tearDownAll");
    }
    
}
